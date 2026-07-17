import io.ktor.client.HttpClient
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.get
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.headersOf
import io.ktor.serialization.kotlinx.json.json
import it.vercruysse.lemmyapi.datatypes.DeleteImageParams
import it.vercruysse.lemmyapi.pictrs.PictrsService
import it.vercruysse.lemmyapi.withBearerAuth
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class AuthenticationProviderTest {

    @Test
    fun `bearer client reads current token and retains unrelated configuration`() = runBlocking {
        val requests = mutableListOf<Map<String, String?>>()
        var auth: String? = "initial"
        val rootClient = HttpClient(
            MockEngine { request ->
                requests += mapOf(
                    "authorization" to request.headers[HttpHeaders.Authorization],
                    "caller" to request.headers["X-Caller"],
                )
                respond("ok")
            },
        ) {
            defaultRequest {
                headers[HttpHeaders.Authorization] = "Bearer inherited"
                headers["X-Caller"] = "retained"
            }
        }
        val bearerClient = rootClient.withBearerAuth { auth }

        bearerClient.get("https://lemmy.world/initial")
        auth = "replacement"
        bearerClient.get("https://lemmy.world/replacement")
        auth = null
        bearerClient.get("https://lemmy.world/logout")

        assertEquals("Bearer initial", requests[0]["authorization"])
        assertEquals("Bearer replacement", requests[1]["authorization"])
        assertNull(requests[2]["authorization"])
        assertEquals(listOf("retained", "retained", "retained"), requests.map { it["caller"] })
        bearerClient.close()
        rootClient.close()
    }

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
        val service = PictrsService(client) { auth }

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
