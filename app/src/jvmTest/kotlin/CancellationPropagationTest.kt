import io.ktor.client.HttpClient
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respondError
import io.ktor.client.engine.mock.respondOk
import io.ktor.client.plugins.HttpRequestTimeoutException
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.ResponseException
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.HttpStatusCode
import io.ktor.serialization.kotlinx.json.json
import it.vercruysse.lemmyapi.utils.deleteResult
import it.vercruysse.lemmyapi.utils.getResult
import it.vercruysse.lemmyapi.utils.postResult
import it.vercruysse.lemmyapi.utils.postUploadResult
import it.vercruysse.lemmyapi.utils.putResult
import kotlinx.coroutines.delay
import kotlinx.coroutines.test.runTest
import kotlin.coroutines.cancellation.CancellationException
import kotlin.test.Test
import kotlin.test.assertFailsWith
import kotlin.test.assertIs
import kotlin.test.assertTrue
import kotlin.time.Duration.Companion.milliseconds

class CancellationPropagationTest {
    @Test
    fun `HTTP result helpers preserve cancellation`() = runTest {
        suspend fun assertCancellation(call: suspend HttpClient.() -> Result<Unit>) {
            val client = cancellingClient()
            client.use { client ->
                assertFailsWith<CancellationException> { client.call() }
            }
        }

        assertCancellation { getResult("test") }
        assertCancellation { postResult("test") }
        assertCancellation { putResult("test") }
        assertCancellation { deleteResult("test") }
        assertCancellation { postUploadResult("test", byteArrayOf()) }
    }

    @Test
    fun `HTTP result helpers still wrap ordinary failures`() = runTest {
        val client = HttpClient(MockEngine) {
            engine {
                addHandler { respondError(HttpStatusCode.InternalServerError) }
            }
            expectSuccess = true
        }

        client.use { client ->
            val result = client.getResult<Unit>("test")
            assertTrue(result.isFailure)
            assertIs<ResponseException>(result.exceptionOrNull())
        }
    }

    @Test
    fun `Http result helpers still wrap timeout cancellation`() = runTest {
        val client = timeoutClient()

        client.use { client ->
            val result = client.getResult<Unit>("test")
            assertTrue(result.isFailure)
            assertIs<HttpRequestTimeoutException>(result.exceptionOrNull())
        }
    }

    private fun cancellingClient(): HttpClient = HttpClient(MockEngine) {
        engine {
            addHandler { throw CancellationException("cancelled") }
        }
        install(ContentNegotiation) { json() }
    }

    private fun timeoutClient(): HttpClient = HttpClient(MockEngine) {
        expectSuccess = true

        engine {
            addHandler {
                delay(500.milliseconds)
                respondOk()
            }
        }

        install(HttpTimeout) {
            requestTimeoutMillis = 1
            connectTimeoutMillis = 1
            socketTimeoutMillis = 1
        }
        install(Logging) {
            level = LogLevel.ALL
        }
    }
}
