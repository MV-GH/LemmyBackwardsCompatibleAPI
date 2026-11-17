import io.ktor.client.HttpClient
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.headersOf
import it.vercruysse.lemmyapi.LemmyApiClient
import it.vercruysse.lemmyapi.LemmyAuth
import it.vercruysse.lemmyapi.LemmyInstance
import it.vercruysse.lemmyapi.LemmyVersion
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.cancellation.CancellationException
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertNull
import kotlin.test.assertTrue

class LegacyUnreadCountsTest {
    private val versions = listOf("0.19.0", "0.19.3", "0.19.4", "0.19.6", "0.19.11", "0.19.21")

    @Test
    fun `ordinary accounts retain notification counts when privileged requests fail`() = runBlocking {
        for (version in versions) {
            val paths = mutableListOf<String>()
            val client = HttpClient(
                MockEngine { request ->
                    paths += request.url.encodedPath
                    val (body, status) = when (request.url.encodedPath) {
                        "/api/v3/user/unread_count" -> """{"replies":2,"mentions":3,"private_messages":4}""" to HttpStatusCode.OK
                        "/api/v3/user/report_count", "/api/v3/admin/registration_application/count" -> "{}" to HttpStatusCode.BadRequest
                        else -> error("Unexpected request: ${request.url}")
                    }
                    respond(body, status, headersOf(HttpHeaders.ContentType, "application/json"))
                },
            )
            val apiClient = LemmyApiClient(client)
            try {
                val api = apiClient.connectForVersion(LemmyInstance("lemmy.ml"), LemmyAuth.Bearer("token"), LemmyVersion(version)).getOrThrow()
                val counts = api.getUnreadCounts().getOrThrow()
                assertEquals(9L, counts.notification_count, version)
                assertNull(counts.report_count, version)
                assertNull(counts.registration_application_count, version)
                assertEquals(listOf("/api/v3/user/unread_count", "/api/v3/user/report_count", "/api/v3/admin/registration_application/count"), paths)
            } finally {
                apiClient.close()
                client.close()
            }
        }
    }

    @Test
    fun `privileged counts are summed and missing private message reports count as zero`() = runBlocking {
        for (version in versions) {
            val client = HttpClient(
                MockEngine { request ->
                    val body = when (request.url.encodedPath) {
                        "/api/v3/user/unread_count" -> """{"replies":1,"mentions":0,"private_messages":0}"""
                        "/api/v3/user/report_count" -> """{"post_reports":2,"comment_reports":3}"""
                        "/api/v3/admin/registration_application/count" -> """{"registration_applications":4}"""
                        else -> error("Unexpected request: ${request.url}")
                    }
                    respond(body, HttpStatusCode.OK, headersOf(HttpHeaders.ContentType, "application/json"))
                },
            )
            val apiClient = LemmyApiClient(client)
            try {
                val api = apiClient.connectForVersion(LemmyInstance("lemmy.ml"), LemmyAuth.Bearer("token"), LemmyVersion(version)).getOrThrow()
                val counts = api.getUnreadCounts().getOrThrow()
                assertEquals(1L, counts.notification_count, version)
                assertEquals(5L, counts.report_count, version)
                assertEquals(4L, counts.registration_application_count, version)
            } finally {
                apiClient.close()
                client.close()
            }
        }
    }

    @Test
    fun `unread request failures propagate and cancellation is not swallowed`() = runBlocking {
        for (version in versions) {
            for (cancel in listOf(false, true)) {
                val client = HttpClient(
                    MockEngine { request ->
                        when (request.url.encodedPath) {
                            "/api/v3/user/unread_count" -> if (cancel) {
                                respond("""{"replies":0,"mentions":0,"private_messages":0}""", HttpStatusCode.OK, headersOf(HttpHeaders.ContentType, "application/json"))
                            } else {
                                respond("{}", HttpStatusCode.BadRequest, headersOf(HttpHeaders.ContentType, "application/json"))
                            }

                            "/api/v3/user/report_count" -> throw CancellationException("cancelled")

                            else -> error("Unexpected request: ${request.url}")
                        }
                    },
                )
                val apiClient = LemmyApiClient(client)
                try {
                    val api = apiClient.connectForVersion(LemmyInstance("lemmy.ml"), LemmyAuth.Bearer("token"), LemmyVersion(version)).getOrThrow()
                    if (cancel) {
                        assertFailsWith<CancellationException> { api.getUnreadCounts() }
                    } else {
                        assertTrue(api.getUnreadCounts().isFailure, version)
                    }
                } finally {
                    apiClient.close()
                    client.close()
                }
            }
        }
    }
}
