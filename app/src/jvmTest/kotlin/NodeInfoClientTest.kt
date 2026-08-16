import io.ktor.client.HttpClient
import io.ktor.client.engine.mock.MockEngine
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
