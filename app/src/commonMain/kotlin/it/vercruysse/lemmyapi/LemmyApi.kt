package it.vercruysse.lemmyapi

import io.github.z4kn4fein.semver.toVersion
import io.ktor.client.call.*
import io.ktor.client.request.*
import it.vercruysse.lemmyapi.dto.NodeInfo
import it.vercruysse.lemmyapi.exception.NotSupportedException
import it.vercruysse.lemmyapi.utils.constructBaseUrl
import it.vercruysse.lemmyapi.utils.dropPatchVersion
import it.vercruysse.lemmyapi.v0x19.datatypes.Login

object LemmyApi {
    const val MAX_SUPPORTED_VERSION = "0.19"
    const val MIN_SUPPORTED_VERSION = "0.18"
    const val API_VERSION = "v3"

    /**
     * Gets the node info of a Lemmy instance
     *
     * @Throws Exception if it is not a Lemmy instance
     */

    suspend fun getNodeInfo(instance: String): Result<NodeInfo> =
        runCatching {
            lenientKtor
                .get("${constructBaseUrl(instance)}/nodeinfo/2.0.json")
                .body<NodeInfo>()
        }

    /**
     * Gets the version of a Lemmy instance
     *
     * @Throws Exception if it is not a Lemmy instance
     */
    fun getVersion(node: NodeInfo): String {
        check(isLemmyInstance(node)) { "Not a Lemmy instance" }
        return node.software.version
    }

    /**
     * Gets the version of a Lemmy instance
     *
     * @Throws Exception if it is not a Lemmy instance
     */
    suspend fun getVersion(instance: String): String {
        val node = getNodeInfo(instance).getOrThrow()
        return getVersion(node)
    }

    /**
     * Returns if it is a fediverse instance, meaning it supports ActivityPub protocol
     */
    suspend fun isFediverse(instance: String): Boolean {
        val nodeResult = getNodeInfo(instance)

        return if (nodeResult.isFailure) {
            false
        } else {
            return isFediverse(nodeResult.getOrThrow())
        }
    }

    /**
     * Returns if it is a fediverse instance, meaning it supports ActivityPub protocol
     */
    fun isFediverse(nodeInfo: NodeInfo): Boolean {
        return nodeInfo.protocols.contains("activitypub")
    }

    /**
     * Returns if it is a lemmy instance
     */
    suspend fun isLemmyInstance(instance: String): Boolean {
        val nodeResult = getNodeInfo(instance)

        return if (nodeResult.isFailure) {
            false
        } else {
            isLemmyInstance(nodeResult.getOrThrow())
        }
    }

    /**
     * Returns if it is a lemmy instance
     */
    fun isLemmyInstance(nodeInfo: NodeInfo): Boolean {
        return nodeInfo.software.name.lowercase() == "lemmy"
    }

    /**
     * Returns a LemmyApi instance.
     *
     * Throws several errors if the Instance isn't available or a Lemmy host or supported.
     *
     * Use the Feature Flags before using certain endpoints as they can be or not available depending
     * on the version of the Lemmy Server instance.
     */

    suspend fun getLemmyApi( // TODO ADD PGP KEY
        instance: String,
        auth: String? = null,
    ): it.vercruysse.lemmyapi.v0x19.LemmyApi {
        val version = getVersion(instance)
        return getLemmyApi(instance, version, auth)
    }

    /**
     * Returns a LemmyApi instance.
     *
     * Throws NotSupportedException if the instance isn't supported.
     *
     * Be warned that this function assumes that the instance and the version are correct.
     *
     * Use the Feature Flags before using certain endpoints as they can be or not available depending
     * on the version of the Lemmy Server instance.
     */

    fun getLemmyApi(
        instance: String,
        version: String,
        auth: String? = null,
    ): it.vercruysse.lemmyapi.v0x19.LemmyApi {
        val baseUrlInstance = constructBaseUrl(instance)
        val ktor = getKtor("$baseUrlInstance/api/$API_VERSION/")

        return when (dropPatchVersion(version)) {
            "0.19" -> it.vercruysse.lemmyapi.v0x19.LemmyApiService(ktor, version.toVersion(false), baseUrlInstance, auth)
            "0.18" -> it.vercruysse.lemmyapi.v0x18.LemmyV0x19Wrapper(ktor, version.toVersion(false), baseUrlInstance, auth)
            else -> throw NotSupportedException("Unsupported Lemmy version: $version")
        }
    }
}

suspend fun main() {
    val api = LemmyApi.getLemmyApi("voyager.lemmy.ml")

    val r = api.login(Login("test", "test"))
    println(r)
    val r2 = api.getSite()
    println(r2)
}
