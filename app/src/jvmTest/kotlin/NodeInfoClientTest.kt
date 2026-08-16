import io.ktor.client.HttpClient
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.MockRequestHandleScope
import io.ktor.client.engine.mock.respond
import io.ktor.client.request.get
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.headersOf
import it.vercruysse.lemmyapi.IGNORE_UNKNOWN_KEYS_JSON
import it.vercruysse.lemmyapi.nodeinfo.Instance
import it.vercruysse.lemmyapi.nodeinfo.NodeInfo
import it.vercruysse.lemmyapi.nodeinfo.NodeInfoClient
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class NodeInfoClientTest {

    @Test
    fun `get Lemmy version rejects another software`() {
        val nodeInfo = IGNORE_UNKNOWN_KEYS_JSON.decodeFromString<NodeInfo>(NODE_INFO.replace("Lemmy", "Mastodon"))

        NodeInfoClient().use { client ->
            assertTrue(client.getLemmyVersion(nodeInfo).isFailure)
        }
    }

    @Test
    fun `remote predicates return successful false values for valid documents`() = runBlocking {
        val suppliedClient = nodeInfoHttpClient(NODE_INFO.replace("Lemmy", "Mastodon").replace("activitypub", "diaspora"))

        NodeInfoClient(suppliedClient).use { client ->
            val instance = Instance("lemmy.world")
            val isFediverse = client.isFediverse(instance)
            val isLemmy = client.isLemmyInstance(instance)
            val version = client.getVersion(instance)
            val lemmyVersion = client.getLemmyVersion(instance)

            assertTrue(isFediverse.isSuccess)
            assertFalse(isFediverse.getOrThrow())
            assertTrue(isLemmy.isSuccess)
            assertFalse(isLemmy.getOrThrow())
            assertTrue(version.isSuccess)
            assertEquals("0.19.11", version.getOrThrow())
            assertTrue(lemmyVersion.isFailure)
        }
        suppliedClient.close()
    }

    @Test
    fun `remote predicates preserve retrieval failures`() = runBlocking {
        val suppliedClient = HttpClient(
            MockEngine {
                respond(
                    content = "Not found",
                    status = HttpStatusCode.NotFound,
                )
            },
        )
        val instance = Instance("lemmy.world")

        NodeInfoClient(suppliedClient).use { client ->
            assertTrue(client.isFediverse(instance).isFailure)
            assertTrue(client.isLemmyInstance(instance).isFailure)
        }
        suppliedClient.close()
    }

    @Test
    fun `quick lookup uses 2x0 endpoint and default lookup remains quick`() = runBlocking {
        val requestedPaths = mutableListOf<String>()
        val suppliedClient = HttpClient(
            MockEngine { request ->
                requestedPaths += request.url.encodedPath
                jsonResponse(NODE_INFO)
            },
        )
        val instance = Instance("lemmy.world")

        NodeInfoClient(suppliedClient).use { client ->
            assertTrue(client.getNodeInfoQuick(instance).isSuccess)
            assertTrue(client.getNodeInfo(instance).isSuccess)
        }

        assertEquals(listOf("/nodeinfo/2.0.json", "/nodeinfo/2.0.json"), requestedPaths)
        suppliedClient.close()
    }

    @Test
    fun `quick lookup retries 2x1 after a 404`() = runBlocking {
        val requestedPaths = mutableListOf<String>()
        val suppliedClient = HttpClient(
            MockEngine { request ->
                requestedPaths += request.url.encodedPath
                when (request.url.encodedPath) {
                    "/nodeinfo/2.0.json" -> jsonResponse("Not found", HttpStatusCode.NotFound)
                    "/nodeinfo/2.1.json" -> jsonResponse(NODE_INFO_2_1)
                    else -> jsonResponse("Unexpected path", HttpStatusCode.BadRequest)
                }
            },
        )

        NodeInfoClient(suppliedClient).use { client ->
            val result = client.getNodeInfoQuick(Instance("lemmy.world"))

            assertTrue(result.isSuccess)
            assertEquals("2.1", result.getOrThrow().version)
        }

        assertEquals(listOf("/nodeinfo/2.0.json", "/nodeinfo/2.1.json"), requestedPaths)
        suppliedClient.close()
    }

    @Test
    fun `quick lookup does not retry non 404 failures`() = runBlocking {
        val requestedPaths = mutableListOf<String>()
        val suppliedClient = HttpClient(
            MockEngine { request ->
                requestedPaths += request.url.encodedPath
                jsonResponse("Server error", HttpStatusCode.InternalServerError)
            },
        )

        NodeInfoClient(suppliedClient).use { client ->
            assertTrue(client.getNodeInfoQuick(Instance("lemmy.world")).isFailure)
        }

        assertTrue(requestedPaths.isNotEmpty())
        assertFalse(requestedPaths.contains("/nodeinfo/2.1.json"))
        suppliedClient.close()
    }

    @Test
    fun `safe lookup prefers 2x1 relation regardless of link order`() = runBlocking {
        val requestedPaths = mutableListOf<String>()
        val suppliedClient = HttpClient(
            MockEngine { request ->
                requestedPaths += request.url.encodedPath
                when (request.url.encodedPath) {
                    "/.well-known/nodeinfo" -> jsonResponse(
                        """
                        {
                          "links": [
                            {"rel": "$NODEINFO_2_0_RELATION", "href": "https://lemmy.world/custom-2.0"},
                            {"rel": "$NODEINFO_2_1_RELATION", "href": "https://lemmy.world/custom-2.1"}
                          ]
                        }
                        """.trimIndent(),
                    )

                    "/custom-2.1" -> jsonResponse(NODE_INFO_2_1)

                    else -> jsonResponse("Unexpected path", HttpStatusCode.BadRequest)
                }
            },
        )

        NodeInfoClient(suppliedClient).use { client ->
            val result = client.getNodeInfoSafe(Instance("lemmy.world"))

            assertTrue(result.isSuccess)
            assertEquals("2.1", result.getOrThrow().version)
        }

        assertEquals(listOf("/.well-known/nodeinfo", "/custom-2.1"), requestedPaths)
        suppliedClient.close()
    }

    @Test
    fun `safe lookup follows a 2x0 relation when no 2x1 relation exists`() = runBlocking {
        val requestedPaths = mutableListOf<String>()
        val suppliedClient = HttpClient(
            MockEngine { request ->
                requestedPaths += request.url.encodedPath
                when (request.url.encodedPath) {
                    "/.well-known/nodeinfo" -> jsonResponse(
                        """
                        {"links": [{"rel": "$NODEINFO_2_0_RELATION", "href": "https://lemmy.world/custom-2.0"}]}
                        """.trimIndent(),
                    )

                    "/custom-2.0" -> jsonResponse(NODE_INFO)

                    else -> jsonResponse("Unexpected path", HttpStatusCode.BadRequest)
                }
            },
        )

        NodeInfoClient(suppliedClient).use { client ->
            assertTrue(client.getNodeInfoSafe(Instance("lemmy.world")).isSuccess)
        }

        assertEquals(listOf("/.well-known/nodeinfo", "/custom-2.0"), requestedPaths)
        suppliedClient.close()
    }

    @Test
    fun `safe lookup fails without a supported discovery link`() = runBlocking {
        val requestedPaths = mutableListOf<String>()
        val suppliedClient = HttpClient(
            MockEngine { request ->
                requestedPaths += request.url.encodedPath
                jsonResponse("""{"links": [{"rel": "unsupported", "href": "https://lemmy.world/guess"}]}""")
            },
        )

        NodeInfoClient(suppliedClient).use { client ->
            val result = client.getNodeInfoSafe(Instance("lemmy.world"))

            assertTrue(result.isFailure)
            assertTrue(result.exceptionOrNull()?.message?.contains("supported") == true)
        }

        assertEquals(listOf("/.well-known/nodeinfo"), requestedPaths)
        suppliedClient.close()
    }

    @Test
    fun `close does not close supplied client`() = runBlocking {
        val suppliedClient = nodeInfoHttpClient(NODE_INFO)
        val client = NodeInfoClient(suppliedClient)

        client.close()

        assertEquals(HttpStatusCode.OK, suppliedClient.get("https://lemmy.world").status)
        suppliedClient.close()
    }

    private fun nodeInfoHttpClient(responseBody: String): HttpClient =
        HttpClient(
            MockEngine {
                respond(
                    content = responseBody,
                    status = HttpStatusCode.OK,
                    headers = headersOf(HttpHeaders.ContentType, "application/json"),
                )
            },
        )

    private fun MockRequestHandleScope.jsonResponse(
        responseBody: String,
        status: HttpStatusCode = HttpStatusCode.OK,
    ) = respond(
        content = responseBody,
        status = status,
        headers = headersOf(HttpHeaders.ContentType, "application/json"),
    )

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
        val NODE_INFO_2_1 = NODE_INFO.replace(
            "\"version\": \"2.0\"",
            "\"version\": \"2.1\", \"metadata\": {\"test\": true}",
        )
        const val NODEINFO_2_0_RELATION = "http://nodeinfo.diaspora.software/ns/schema/2.0"
        const val NODEINFO_2_1_RELATION = "http://nodeinfo.diaspora.software/ns/schema/2.1"
    }
}
