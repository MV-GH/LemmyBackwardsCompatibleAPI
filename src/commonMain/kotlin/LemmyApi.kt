import dto.NodeInfo
import io.ktor.client.call.*
import io.ktor.client.request.*
import utils.dropPatchVersion
import utils.isBetweenVersions
import v0x18.datatypes.GetSite

object LemmyApi {
    const val MAX_SUPPORTED_VERSION = "0.18"
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

    suspend fun getLemmyApi(instance: String): v0x18.LemmyApi {
        val version = getVersion(instance)

        if (!isBetweenVersions(dropPatchVersion(version), MIN_SUPPORTED_VERSION, MAX_SUPPORTED_VERSION)) throw Exception("Unsupported Lemmy version: $version")

        return v0x18.LemmyApiService(getKtor("$instance/api/$API_VERSION/"))
    }
}

suspend fun main() {
    println(LemmyApi.getNodeInfo("https://lemmy.ml"))

    val api = LemmyApi.getLemmyApi("https://lemmy.ml")
    println(api.getSite(GetSite()))
}
