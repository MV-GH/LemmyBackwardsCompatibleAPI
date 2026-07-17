import io.ktor.client.HttpClient
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respondError
import io.ktor.client.plugins.ResponseException
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.HttpStatusCode
import io.ktor.serialization.kotlinx.json.json
import it.vercruysse.lemmyapi.utils.deleteResult
import it.vercruysse.lemmyapi.utils.getResult
import it.vercruysse.lemmyapi.utils.postResult
import it.vercruysse.lemmyapi.utils.postUploadResult
import it.vercruysse.lemmyapi.utils.putResult
import kotlinx.coroutines.test.runTest
import kotlin.coroutines.cancellation.CancellationException
import kotlin.test.Test
import kotlin.test.assertFailsWith
import kotlin.test.assertIs
import kotlin.test.assertTrue

class CancellationPropagationTest {
    @Test
    fun `HTTP result helpers preserve cancellation`() = runTest {
        suspend fun assertCancellation(call: suspend HttpClient.() -> Result<Unit>) {
            val client = cancellingClient()
            try {
                assertFailsWith<CancellationException> { client.call() }
            } finally {
                client.close()
            }
        }

        assertCancellation { getResult("/") }
        assertCancellation { postResult("/") }
        assertCancellation { putResult("/") }
        assertCancellation { deleteResult("/") }
        assertCancellation { postUploadResult("/", byteArrayOf()) }
    }

    @Test
    fun `HTTP result helpers still wrap ordinary failures`() = runTest {
        val client = HttpClient(MockEngine) {
            engine {
                addHandler { respondError(HttpStatusCode.InternalServerError) }
            }
            expectSuccess = true
        }

        try {
            val result = client.getResult<Unit>("/")
            assertTrue(result.isFailure)
            assertIs<ResponseException>(result.exceptionOrNull())
        } finally {
            client.close()
        }
    }

    private fun cancellingClient(): HttpClient = HttpClient(MockEngine) {
        engine {
            addHandler { throw CancellationException("cancelled") }
        }
        install(ContentNegotiation) { json() }
    }
}
