import io.ktor.client.HttpClient
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.headersOf
import io.ktor.serialization.kotlinx.json.json
import it.vercruysse.lemmyapi.datatypes.DeleteImageParams
import it.vercruysse.lemmyapi.pictrs.PictrsService
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class AuthenticationProviderTest {

    @Test
    fun `Pictrs requests read current token and omit cookie after logout`() = runBlocking {
        val cookies = mutableListOf<String?>()
        var auth: String? = "initial"
        val client = HttpClient(
            MockEngine { request ->
                cookies += request.headers[HttpHeaders.Cookie]
                respond(
                    content = if (request.url.encodedPath == "/pictrs/image") {
                        """{"msg":"ok","files":[{"file":"image.jpg","delete_token":"delete"}]}"""
                    } else {
                        ""
                    },
                    status = HttpStatusCode.OK,
                    headers = headersOf(HttpHeaders.ContentType, "application/json"),
                )
            },
        ) {
            install(ContentNegotiation) {
                json()
            }
        }
        val service = PictrsService(client, "https://lemmy.world") { auth }

        service.uploadImage(byteArrayOf(1)).getOrThrow()
        auth = "replacement"
        service.deleteMedia(DeleteImageParams("/pictrs/image/delete/delete/image.jpg")).getOrThrow()
        auth = null
        service.deleteMedia(DeleteImageParams("/pictrs/image/delete/delete/image.jpg")).getOrThrow()

        assertEquals("jwt=initial", cookies[0])
        assertEquals("jwt=replacement", cookies[1])
        assertNull(cookies[2])
        client.close()
    }
}
