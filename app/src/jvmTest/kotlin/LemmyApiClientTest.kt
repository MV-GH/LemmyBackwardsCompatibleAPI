import io.ktor.client.HttpClient
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.get
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.headersOf
import it.vercruysse.lemmyapi.LemmyApiClient
import it.vercruysse.lemmyapi.LemmyApiOptions
import it.vercruysse.lemmyapi.LemmyAuth
import it.vercruysse.lemmyapi.LemmyInstance
import it.vercruysse.lemmyapi.LemmyVersion
import it.vercruysse.lemmyapi.VersionPolicy
import it.vercruysse.lemmyapi.datatypes.GetPosts
import it.vercruysse.lemmyapi.exception.NotSupportedException
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.cancellation.CancellationException
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertFalse
import kotlin.test.assertIs
import kotlin.test.assertSame
import kotlin.test.assertTrue
import kotlin.time.Duration.Companion.INFINITE
import kotlin.time.Duration.Companion.seconds

class LemmyApiClientTest {

    @Test
    fun `create retains caller configuration and applies required configuration`() = runBlocking {
        val requests = mutableListOf<String>()
        val suppliedClient = HttpClient(
            MockEngine { request ->
                requests += request.headers["X-Test-Client"].orEmpty()
                assertEquals("TestClient/1.0", request.headers[HttpHeaders.UserAgent])
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
        val client = LemmyApiClient(suppliedClient, LemmyApiOptions(userAgent = "TestClient/1.0"))

        val controller = client.connectForVersion(LemmyInstance("lemmy.world"), LemmyVersion("0.19.11")).getOrThrow()
        controller.getPosts(GetPosts()).getOrThrow()

        assertEquals(listOf("retained"), requests)
        client.close()
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
        val client = LemmyApiClient(suppliedClient)

        val controller = client.connect(LemmyInstance("lemmy.world")).getOrThrow()

        assertIs<it.vercruysse.lemmyapi.v0.x19.x11.LemmyApiUniWrapper>(controller)
        assertEquals(1, requestCount)
        client.close()
        suppliedClient.close()
    }

    @Test
    fun `close does not close supplied client`() = runBlocking<Unit> {
        val suppliedClient = HttpClient(MockEngine { respond("ok") })
        val client = LemmyApiClient(suppliedClient)

        client.close()

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
        val client = LemmyApiClient(suppliedClient)

        assertFailsWith<CancellationException> {
            client.connect(LemmyInstance("lemmy.world"))
        }

        client.close()
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
        val client = LemmyApiClient(suppliedClient)
        val controller = client.connectForVersion(LemmyInstance("lemmy.world"), LemmyVersion("0.19.11")).getOrThrow()

        client.close()

        assertFailsWith<CancellationException> {
            controller.getPosts(GetPosts()).getOrThrow()
        }
        assertEquals(HttpStatusCode.OK, suppliedClient.get("https://lemmy.world").status)
        suppliedClient.close()
    }

    @Test
    fun `created controllers do not own HTTP resources`() {
        val client = LemmyApiClient()
        val controller = client.connectForVersion(LemmyInstance("lemmy.world"), LemmyVersion("0.19.11")).getOrThrow()

        assertFalse(controller is AutoCloseable)

        client.close()
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
        val client = LemmyApiClient(suppliedClient)
        val controller = client.connectForVersion(
            LemmyInstance("lemmy.world"),
            LemmyAuth.fromToken("initial"),
            LemmyVersion("1.0.0"),

        ).getOrThrow()

        controller.getPosts(GetPosts())
        controller.updateAuth(LemmyAuth.fromToken("replacement"))
        controller.getPosts(GetPosts())
        controller.updateAuth(LemmyAuth.fromToken(null))
        controller.getPosts(GetPosts())

        assertEquals(listOf("Bearer initial", "Bearer replacement", null), authorizationHeaders)
        client.close()
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
        val client = LemmyApiClient(suppliedClient)
        val controller = client.connectForVersion(
            LemmyInstance("lemmy.world"),
            LemmyAuth.fromToken("legacy-token"),
            LemmyVersion("0.18.5"),

        ).getOrThrow()

        controller.getSite()
        controller.updateAuth(LemmyAuth.fromToken("replacement"))
        controller.getSite()
        controller.updateAuth(LemmyAuth.fromToken(null))
        controller.getSite()

        assertEquals(listOf<String?>(null, null, null), authorizationHeaders)
        assertEquals(listOf("legacy-token", "replacement", null), authParameters)
        client.close()
        suppliedClient.close()
    }

    @Test
    fun `typed connection owns instance authentication and version`() = runBlocking {
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
        val instance = LemmyInstance("lemmy.world")
        val version = LemmyVersion("1.0.0")

        LemmyApiClient(suppliedClient).use { client ->
            val controller = client.connectForVersion(instance, LemmyAuth.Bearer("initial"), version).getOrThrow()

            assertEquals(instance, controller.instance)
            assertEquals(version, controller.version)
            controller.getPosts(GetPosts())
            controller.updateAuth(LemmyAuth.Bearer("replacement"))
            controller.getPosts(GetPosts())
            controller.clearAuth()
            controller.getPosts(GetPosts())
        }

        assertEquals(listOf("Bearer initial", "Bearer replacement", null), authorizationHeaders)
        suppliedClient.close()
    }

    @Test
    fun `strict version policy rejects unknown future versions`() {
        LemmyApiClient(
            options = LemmyApiOptions(
                requestTimeout = 10.seconds,
                maxRetries = 0,
                userAgent = "TestClient/1.0",
                versionPolicy = VersionPolicy.Strict,
            ),
        ).use { client ->
            val instance = LemmyInstance("lemmy.world")
            val result = client.connectForVersion(instance, LemmyVersion("0.19.12"))
            val oldLineResult = client.connectForVersion(instance, LemmyVersion("0.18.6"))
            val newLineResult = client.connectForVersion(instance, LemmyVersion("1.1.0"))

            assertTrue(result.isFailure)
            assertIs<NotSupportedException>(result.exceptionOrNull())
            assertIs<NotSupportedException>(oldLineResult.exceptionOrNull())
            assertIs<NotSupportedException>(newLineResult.exceptionOrNull())
        }
    }

    @Test
    fun `latest known compatibility policy uses newest wrapper`() {
        LemmyApiClient().use { client ->
            val controller = client.connectForVersion(
                LemmyInstance("lemmy.world"),
                LemmyVersion("0.19.12"),
            ).getOrThrow()

            assertIs<it.vercruysse.lemmyapi.v0.x19.x11.LemmyApiUniWrapper>(controller)
        }
    }

    @Test
    fun `typed values reject invalid input`() {
        assertFailsWith<IllegalArgumentException> { LemmyInstance("  ") }
        assertFailsWith<IllegalArgumentException> { LemmyVersion("invalid") }
        assertFailsWith<IllegalArgumentException> { LemmyAuth.Bearer("") }
        assertFailsWith<IllegalArgumentException> { LemmyAuth.fromToken("") }
        assertFailsWith<IllegalArgumentException> { LemmyApiOptions(maxRetries = -1) }
        assertFailsWith<IllegalArgumentException> { LemmyApiOptions(requestTimeout = INFINITE) }
    }

    @Test
    fun `nullable token factory creates the expected auth values`() {
        assertSame(LemmyAuth.fromToken(null), LemmyAuth.Anonymous)
        assertEquals(LemmyAuth.Bearer("token"), LemmyAuth.fromToken("token"))
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
