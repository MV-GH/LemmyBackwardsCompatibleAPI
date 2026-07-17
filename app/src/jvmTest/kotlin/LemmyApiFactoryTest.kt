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
import kotlin.test.assertFalse
import kotlin.test.assertIs
import kotlin.test.assertNull

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

        val controller = factory.createForVersion("lemmy.world", "0.19.11").getOrThrow()
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

        val controller = factory.create("lemmy.world").getOrThrow()

        assertIs<it.vercruysse.lemmyapi.v0.x19.x11.LemmyApiUniWrapper>(controller)
        assertEquals(1, requestCount)
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

    @Test
    fun `version discovery preserves coroutine cancellation`() = runBlocking<Unit> {
        val suppliedClient = HttpClient(
            MockEngine {
                throw CancellationException("cancelled")
            },
        )
        val factory = LemmyApiFactory(suppliedClient)

        assertFailsWith<CancellationException> {
            factory.create("lemmy.world")
        }

        factory.close()
        suppliedClient.close()
    }

    @Test
    fun `close releases clients used by created controllers`() = runBlocking<Unit> {
        val suppliedClient = HttpClient(
            MockEngine {
                respond(
                    content = """{"posts": [], "next_page": null}""",
                    status = HttpStatusCode.OK,
                    headers = headersOf(HttpHeaders.ContentType, "application/json"),
                )
            },
        )
        val factory = LemmyApiFactory(suppliedClient)
        val controller = factory.createForVersion("lemmy.world", "0.19.11").getOrThrow()

        factory.close()

        assertFailsWith<CancellationException> {
            controller.getPosts(it.vercruysse.lemmyapi.datatypes.GetPosts()).getOrThrow()
        }
        assertEquals(HttpStatusCode.OK, suppliedClient.get("https://lemmy.world").status)
        suppliedClient.close()
    }

    @Test
    fun `created controllers do not own HTTP resources`() {
        val factory = LemmyApiFactory()
        val controller = factory.createForVersion("lemmy.world", "0.19.11").getOrThrow()

        assertFalse(controller is AutoCloseable)

        factory.close()
    }

    @Test
    fun `version one controller reads current authentication`() = runBlocking {
        val authorizationHeaders = mutableListOf<String?>()
        val suppliedClient = HttpClient(
            MockEngine { request ->
                authorizationHeaders += request.headers[HttpHeaders.Authorization]
                respond(
                    content = "{}",
                    status = HttpStatusCode.OK,
                    headers = headersOf(HttpHeaders.ContentType, "application/json"),
                )
            },
        )
        val factory = LemmyApiFactory(suppliedClient)
        val controller = factory.createForVersion("lemmy.world", "1.0.0", "initial").getOrThrow()

        controller.getPosts(it.vercruysse.lemmyapi.datatypes.GetPosts())
        controller.auth = "replacement"
        controller.getPosts(it.vercruysse.lemmyapi.datatypes.GetPosts())
        controller.auth = null
        controller.getPosts(it.vercruysse.lemmyapi.datatypes.GetPosts())

        assertEquals(listOf("Bearer initial", "Bearer replacement", null), authorizationHeaders)
        factory.close()
        suppliedClient.close()
    }

    @Test
    fun `version zero eighteen does not add bearer authentication`() = runBlocking {
        val authorizationHeaders = mutableListOf<String?>()
        val authParameters = mutableListOf<String?>()
        val suppliedClient = HttpClient(
            MockEngine { request ->
                authorizationHeaders += request.headers[HttpHeaders.Authorization]
                authParameters += request.url.parameters["auth"]
                respond(
                    content = "{}",
                    status = HttpStatusCode.OK,
                    headers = headersOf(HttpHeaders.ContentType, "application/json"),
                )
            },
        )
        val factory = LemmyApiFactory(suppliedClient)
        val controller = factory.createForVersion("lemmy.world", "0.18.5", "legacy-token").getOrThrow()

        controller.getSite()
        controller.auth = "replacement"
        controller.getSite()
        controller.auth = null
        controller.getSite()

        assertEquals(listOf<String?>(null, null, null), authorizationHeaders)
        assertEquals(listOf("legacy-token", "replacement", null), authParameters)
        factory.close()
        suppliedClient.close()
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
