import it.vercruysse.lemmyapi.dto.NodeInfo
import it.vercruysse.lemmyapi.lenientJson
import kotlin.test.Test
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
        }""".trimIndent()

        val nodeInfo = lenientJson.decodeFromString<NodeInfo>(nodeInfoJson)
        assertNotNull(nodeInfo)
        assertNotNull(nodeInfo.protocols)
    }

    @Test
    fun `NodeInfo should allow protocol field as null`() {
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
        }""".trimIndent()

        val nodeInfo = lenientJson.decodeFromString<NodeInfo>(nodeInfoJson)
        assertNotNull(nodeInfo)
        assertNotNull(nodeInfo.protocols)
        assertTrue { nodeInfo.protocols.isEmpty() }
    }
}
