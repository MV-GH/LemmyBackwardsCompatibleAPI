import dto.NodeInfo
import io.ktor.client.call.*
import io.ktor.client.request.*
import utils.dropPatchVersion

object LemmyApi {
    const val MAX_SUPPORTED_VERSION = "0.19"
    const val MIN_SUPPORTED_VERSION = "0.18"
    const val API_VERSION = "v3"

    /**
     * Gets the node info of a Lemmy instance
     *
     * @Throws Exception if it is not a Lemmy instance
     */

    suspend fun getNodeInfo(instance: String): NodeInfo {
        return coreKtor.get("$instance/nodeinfo/2.0.json").body<NodeInfo>()
    }

    /**
     * Gets the version of a Lemmy instance
     *
     * @Throws Exception if it is not a Lemmy instance
     */
    suspend fun getVersion(instance: String): String {
        val node = getNodeInfo(instance)
        if (node.software.name.lowercase() != "lemmy") throw Exception("Not a Lemmy instance")
        return node.software.version
    }

    /**
     * Returns a LemmyApi instance.
     *
     * Throws several errors if the Instance isn't available or a Lemmy host or supported.
     *
     * Use the Feature Flags before using certain endpoints as they can be or not available depending
     * on the version of the Lemmy Server.
     */

    suspend fun getLemmyApi(instance: String, auth: String? = null): v0x19.LemmyApi {
        val version = getVersion(instance)

        val ktor = lazy { getKtor("$instance/api/$API_VERSION/") }

        return when (dropPatchVersion(version)) {
            "0.19" -> v0x19.LemmyApiService(ktor.value, auth)
            "0.18" -> v0x18.LemmyV0x19Wrapper(ktor.value, auth)
            else -> throw Exception("Unsupported Lemmy version: $version")
        }
    }
}

suspend fun main() {
    // println(LemmyApi.getNodeInfo("https://lemmy.ml"))

    val api = LemmyApi.getLemmyApi("https://lemmy.ml")
    println(api.getSite())
}
