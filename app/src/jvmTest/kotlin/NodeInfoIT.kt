import com.github.tomakehurst.wiremock.core.WireMockConfiguration
import com.github.tomakehurst.wiremock.junit5.WireMockExtension
import com.marcinziolo.kotlin.wiremock.equalTo
import com.marcinziolo.kotlin.wiremock.get
import com.marcinziolo.kotlin.wiremock.returnsJson
import it.vercruysse.lemmyapi.LemmyApi
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.RegisterExtension

class NodeInfoIT {

    companion object {
        @JvmField
        @RegisterExtension
        var wm = WireMockExtension.newInstance()
            .options(WireMockConfiguration.wireMockConfig().dynamicPort())
            .build()
    }

    @Test
    fun `Should allow NodeInfo without protocols field`() {
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

        wm.get {
            url equalTo "/nodeinfo/2.0.json"
        } returnsJson {
            body = nodeInfoJson
        }

        val nodeInfo = runBlocking {
            LemmyApi.getNodeInfo(wm.baseUrl() + "/nodeinfo/2.0.json")
        }

        assertNotNull(nodeInfo.isSuccess)
        assertNotNull(nodeInfo.getOrThrow().protocols)
    }
}
