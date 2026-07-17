import io.ktor.client.HttpClient
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.get
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.headersOf
import it.vercruysse.lemmyapi.LemmyApiFactory
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.cancellation.CancellationException
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertIs

class LemmyApiFactoryTest {

    @Test
    fun `create retains caller configuration and applies required configuration`() = runBlocking {
        val requests = mutableListOf<String>()
        val suppliedClient = HttpClient(
            MockEngine { request ->
                requests += request.headers["X-Test-Client"].orEmpty()
                assertEquals("LemmyKotlinApi", request.headers[HttpHeaders.UserAgent])
                respond(
                    content = """{"posts": [], "next_page": null}""",
                    status = HttpStatusCode.OK,
                    headers = headersOf(HttpHeaders.ContentType, "application/json"),
                )
            },
        ) {
            defaultRequest {
                headers.append("X-Test-Client", "retained")
            }
        }
        val factory = LemmyApiFactory(suppliedClient)

        val controller = factory.create("lemmy.world", "0.19.11")
        controller.getPosts(it.vercruysse.lemmyapi.datatypes.GetPosts()).getOrThrow()

        assertEquals(listOf("retained"), requests)
        factory.close()
        suppliedClient.close()
    }

    @Test
    fun `create discovers version with supplied client`() = runBlocking {
        var requestCount = 0
        val suppliedClient = HttpClient(
            MockEngine { request ->
                requestCount++
                assertEquals("/nodeinfo/2.0.json", request.url.encodedPath)
                respond(
                    content = NODE_INFO,
                    status = HttpStatusCode.OK,
                    headers = headersOf(HttpHeaders.ContentType, "application/json"),
                )
            },
        )
        val factory = LemmyApiFactory(suppliedClient)

        val controller = factory.create("lemmy.world")
        controller.getNodeInfo().getOrThrow()

        assertIs<it.vercruysse.lemmyapi.v0.x19.x11.LemmyApiUniWrapper>(controller)
        assertEquals(2, requestCount)
        factory.close()
        suppliedClient.close()
    }

    @Test
    fun `close does not close supplied client`() = runBlocking<Unit> {
        val suppliedClient = HttpClient(MockEngine { respond("ok") })
        val factory = LemmyApiFactory(suppliedClient)

        factory.close()

        assertEquals(HttpStatusCode.OK, suppliedClient.get("https://lemmy.world").status)
        suppliedClient.close()

        assertFailsWith(CancellationException::class) { suppliedClient.get("https://lemmy.world").status }
    }

    private companion object {
        val NODE_INFO =
            """{
                "version": "2.0",
                "software": {"name": "Lemmy", "version": "0.19.11"},
                "protocols": ["activitypub"],
                "openRegistrations": true,
                "usage": {
                    "users": {"total": 1, "activeHalfyear": 1, "activeMonth": 1},
                    "localPosts": 1,
                    "localComments": 1
                }
            }
            """.trimIndent()
    }
}
