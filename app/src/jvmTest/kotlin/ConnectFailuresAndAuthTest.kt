import io.ktor.client.HttpClient
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.MockRequestHandler
import io.ktor.client.engine.mock.respond
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.headersOf
import it.vercruysse.lemmyapi.LemmyApiClient
import it.vercruysse.lemmyapi.LemmyApiOptions
import it.vercruysse.lemmyapi.LemmyAuth
import it.vercruysse.lemmyapi.LemmyInstance
import it.vercruysse.lemmyapi.LemmyVersion
import it.vercruysse.lemmyapi.VersionPolicy
import it.vercruysse.lemmyapi.datatypes.Login
import it.vercruysse.lemmyapi.exception.LemmyBadRequestException
import it.vercruysse.lemmyapi.exception.LemmyConnectException
import it.vercruysse.lemmyapi.exception.TokenRedactedException
import it.vercruysse.lemmyapi.redacting
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertIs
import kotlin.test.assertNull
import kotlin.test.assertSame
import kotlin.test.assertTrue

class ConnectFailuresAndAuthTest {

    private fun nodeInfo(software: String, version: String) =
        """{"version":"2.0","software":{"name":"$software","version":"$version"},"protocols":["activitypub"],""" +
            """"openRegistrations":true,"usage":{"users":{}}}"""

    private fun connectWith(nodeInfoBody: String, status: HttpStatusCode = HttpStatusCode.OK): Throwable? = runBlocking {
        val http = HttpClient(
            MockEngine {
                respond(nodeInfoBody, status, headersOf(HttpHeaders.ContentType, "application/json"))
            },
        )
        LemmyApiClient(http, LemmyApiOptions(maxRetries = 0, versionPolicy = VersionPolicy.Strict)).use {
            it.connect(LemmyInstance("lemmy.world")).exceptionOrNull()
        }.also { http.close() }
    }

    private fun clientFor(
        rejected: MutableList<String>,
        handler: MockRequestHandler,
    ): Pair<HttpClient, LemmyApiClient> {
        val http = HttpClient(MockEngine(handler))
        val options = LemmyApiOptions(maxRetries = 0, onAuthRejected = { rejected += it.token })
        return http to LemmyApiClient(http, options)
    }

    private fun json(status: HttpStatusCode, body: String): MockRequestHandler = {
        respond(body, status, headersOf(HttpHeaders.ContentType, "application/json"))
    }

    @Test
    fun `connect names software that is not Lemmy`() {
        val failure = assertIs<LemmyConnectException.NotLemmy>(connectWith(nodeInfo("mastodon", "4.2.0")))
        assertEquals("mastodon", failure.nodeInfo.software.name)
    }

    @Test
    fun `connect fails instead of throwing for an unreadable version`() {
        val failure = assertIs<LemmyConnectException.InvalidVersion>(connectWith(nodeInfo("lemmy", "unknown")))
        assertEquals("unknown", failure.rawVersion)
    }

    @Test
    fun `connect names the unsupported version`() {
        val failure = assertIs<LemmyConnectException.UnsupportedVersion>(connectWith(nodeInfo("lemmy", "0.17.4")))
        assertEquals(LemmyVersion("0.17.4"), failure.version)
    }

    @Test
    fun `connect wraps a NodeInfo failure`() {
        val failure = assertIs<LemmyConnectException.NodeInfoUnavailable>(
            connectWith("oops", HttpStatusCode.InternalServerError),
        )
        assertTrue(failure.cause != null)
    }

    @Test
    fun `rejected token is reported with the token the request carried`() = runBlocking {
        val rejected = mutableListOf<String>()
        val (http, client) = clientFor(rejected, json(HttpStatusCode.BadRequest, """{"error":"not_logged_in"}"""))
        val api = client.connectForVersion(LemmyInstance("lemmy.world"), LemmyAuth.fromToken("old"), LemmyVersion("1.0.0")).getOrThrow()

        assertIs<LemmyBadRequestException>(api.getSite().exceptionOrNull())
        api.updateAuth(LemmyAuth.fromToken("new"))
        api.getSite()
        api.clearAuth()
        api.getSite()

        assertEquals(listOf("old", "new"), rejected)
        client.close()
        http.close()
    }

    @Test
    fun `wrong password on login is not a rejected token`() = runBlocking {
        val rejected = mutableListOf<String>()
        val (http, client) = clientFor(rejected, json(HttpStatusCode.BadRequest, """{"error":"incorrect_login"}"""))
        val api = client.connectForVersion(LemmyInstance("lemmy.world"), LemmyAuth.fromToken("tok"), LemmyVersion("1.0.0")).getOrThrow()

        assertIs<LemmyBadRequestException>(api.login(Login("user", "wrong")).exceptionOrNull())

        assertTrue(rejected.isEmpty())
        client.close()
        http.close()
    }

    @Test
    fun `401 without a Lemmy error is a rejected token`() = runBlocking {
        val rejected = mutableListOf<String>()
        val (http, client) = clientFor(rejected) { respond("", HttpStatusCode.Unauthorized) }
        val api = client.connectForVersion(LemmyInstance("lemmy.world"), LemmyAuth.fromToken("tok"), LemmyVersion("0.19.11")).getOrThrow()

        api.getSite()

        assertEquals(listOf("tok"), rejected)
        client.close()
        http.close()
    }

    @Test
    fun `version zero eighteen reports a rejected token sent in the form`() = runBlocking {
        val rejected = mutableListOf<String>()
        val (http, client) = clientFor(rejected, json(HttpStatusCode.BadRequest, """{"error":"not_logged_in"}"""))
        val api = client.connectForVersion(LemmyInstance("lemmy.world"), LemmyAuth.fromToken("legacy"), LemmyVersion("0.18.5")).getOrThrow()

        api.getSite()

        assertEquals(listOf("legacy"), rejected)
        client.close()
        http.close()
    }

    @Test
    fun `version zero eighteen failures do not leak the token`() = runBlocking {
        val (http, client) = clientFor(mutableListOf()) { respond("gateway down", HttpStatusCode.BadGateway) }
        val api = client.connectForVersion(LemmyInstance("lemmy.world"), LemmyAuth.fromToken("secret-token"), LemmyVersion("0.18.5")).getOrThrow()

        val failure = assertIs<TokenRedactedException>(api.getSite().exceptionOrNull())

        assertFalse(failure.message!!.contains("secret-token"))
        assertTrue(failure.message!!.contains("<redacted>"))
        assertEquals(502, failure.statusCode)
        assertFalse(failure.isNetworkFailure)
        assertNull(failure.cause)
        client.close()
        http.close()
    }

    @Test
    fun `redaction stops on a cause chain that loops`() {
        val first = Exception("outer")
        val second = Exception("inner", first)
        first.initCause(second)

        assertSame(first, first.redacting("secret-token"))
    }

    @Test
    fun `failures without the token keep their type`() = runBlocking {
        val (http, client) = clientFor(mutableListOf()) { respond("gateway down", HttpStatusCode.BadGateway) }
        val api = client.connectForVersion(LemmyInstance("lemmy.world"), LemmyAuth.fromToken("secret-token"), LemmyVersion("1.0.0")).getOrThrow()

        assertIs<io.ktor.client.plugins.ServerResponseException>(api.getSite().exceptionOrNull())
        client.close()
        http.close()
    }
}
