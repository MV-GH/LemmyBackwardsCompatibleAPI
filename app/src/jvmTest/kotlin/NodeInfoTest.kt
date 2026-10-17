import it.vercruysse.lemmyapi.IGNORE_UNKNOWN_KEYS_JSON
import it.vercruysse.lemmyapi.nodeinfo.NodeInfo
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.JsonException
import kotlin.test.Test
import kotlin.test.assertFailsWith
import kotlin.test.assertNotNull
import kotlin.test.assertNull

class NodeInfoTest {

    @Test
    fun `NodeInfo should allow missing protocols field`() {
        val nodeInfoJson = """{
            "version": "2.0",
            "software": {
                "name": "Lemmy",
                "version": "0.10.0"
            },
            "openRegistrations": true,
            "usage": {
                "users": {
                    "total": 1,
                    "activeHalfyear": 1,
                    "activeMonth": 1
                },
                "localPosts": 1,
                "localComments": 1
            }
        }
        """.trimIndent()

        val nodeInfo = IGNORE_UNKNOWN_KEYS_JSON.decodeFromString<NodeInfo>(nodeInfoJson)
        assertNotNull(nodeInfo)
        assertNotNull(nodeInfo.protocols)
    }

    @Test
    fun `NodeInfo should allow optional usage counters to be missing`() {
        val nodeInfoJson = """{
            "version": "2.0",
            "software": {
                "name": "Mastodon",
                "version": "4.0.0"
            },
            "openRegistrations": true,
            "usage": {
                "users": {}
            }
        }
        """.trimIndent()

        val nodeInfo = IGNORE_UNKNOWN_KEYS_JSON.decodeFromString<NodeInfo>(nodeInfoJson)

        assertNull(nodeInfo.usage.localPosts)
        assertNull(nodeInfo.usage.localComments)
        assertNull(nodeInfo.usage.users.activeHalfyear)
        assertNull(nodeInfo.usage.users.activeMonth)
        assertNull(nodeInfo.usage.users.total)
    }

    @OptIn(ExperimentalSerializationApi::class)
    @Test
    fun `NodeInfo fails when protocols field is null`() {
        val nodeInfoJson = """{
            "version": "2.0",
            "software": {
                "name": "Lemmy",
                "version": "0.10.0"
            },
            "protocols": null,
            "openRegistrations": true,
            "usage": {
                "users": {
                    "total": 1,
                    "activeHalfyear": 1,
                    "activeMonth": 1
                },
                "localPosts": 1,
                "localComments": 1
            }
        }
        """.trimIndent()

        assertFailsWith<JsonException> { IGNORE_UNKNOWN_KEYS_JSON.decodeFromString<NodeInfo>(nodeInfoJson) }
    }
}
