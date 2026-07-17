import it.vercruysse.lemmyapi.IGNORE_UNKNOWN_KEYS_JSON
import it.vercruysse.lemmyapi.nodeinfo.NodeInfo
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonDecodingException
import kotlinx.serialization.json.JsonException
import kotlin.test.Test
import kotlin.test.assertFailsWith
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

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

        assertFailsWith<JsonException> {  IGNORE_UNKNOWN_KEYS_JSON.decodeFromString<NodeInfo>(nodeInfoJson) }
    }
}
