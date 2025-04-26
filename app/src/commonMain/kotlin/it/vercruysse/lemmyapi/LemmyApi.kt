package it.vercruysse.lemmyapi

import io.github.z4kn4fein.semver.toVersion
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.*
import io.ktor.client.request.*
import it.vercruysse.lemmyapi.dto.NodeInfo
import it.vercruysse.lemmyapi.exception.NotSupportedException
import it.vercruysse.lemmyapi.utils.constructBaseUrl

object LemmyApi {
    const val MAX_SUPPORTED_VERSION = "0.19"
    const val MIN_SUPPORTED_VERSION = "0.18"
    const val API_VERSION = "v3"
    var defaultClient = coreHttpClient

    /**
     * Overrides the config for the default HTTP Client.
     */
    internal fun getKtorClient(baseUrl: String): HttpClient =
        defaultClient.config {
            defaultRequest {
                url(baseUrl)
            }
        }

    /**
     * Gets the node info of a Lemmy instance
     */
    suspend fun getNodeInfo(instance: String, httpClient: HttpClient = lenientClient): Result<NodeInfo> =
        runCatching {
            httpClient
                .get("${constructBaseUrl(instance)}/nodeinfo/2.0.json")
                .body<NodeInfo>()
        }

    /**
     * Gets the version from NodeInfo
     */
    fun getVersion(node: NodeInfo): String = node.software.version

    /**
     * Gets the version from the NodeInfo of an instance
     *
     * @Throws Exception if it is not a Lemmy instance
     */
    fun getLemmyVersion(node: NodeInfo): String {
        check(isLemmyInstance(node)) { "Not a Lemmy instance" }
        return getVersion(node)
    }

    /**
     * Gets the version of a Lemmy instance
     *
     * @Throws Exception if it is not a Lemmy instance
     * @Throws Exception if nodeInfo failed to retrieve
     */
    suspend fun getLemmyVersion(instance: String): String {
        val node = getNodeInfo(instance).getOrThrow()
        return getLemmyVersion(node)
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
    fun isFediverse(nodeInfo: NodeInfo): Boolean = nodeInfo.protocols.contains("activitypub")

    /**
     * Returns if it is a Lemmy instance
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
     * Returns if it is a Lemmy instance
     */
    fun isLemmyInstance(nodeInfo: NodeInfo): Boolean = nodeInfo.software.name.lowercase() == "lemmy"

    /**
     * Returns a LemmyApi instance.
     *
     * Throws several errors if the Instance isn't available or a Lemmy host or supported.
     *
     * Use the Feature Flags before using certain endpoints as they can be or not available depending
     * on the version of the Lemmy Server instance.
     */

    suspend fun getLemmyApi(
        instance: String,
        auth: String? = null,
    ): LemmyApiBaseController {
        val version = getLemmyVersion(instance)
        return getLemmyApi(instance, version, auth)
    }

    /**
     * Returns a LemmyApi instance.
     *
     * @throws NotSupportedException if the instance isn't supported.
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
    ): LemmyApiBaseController {
        val baseUrlInstance = constructBaseUrl(instance) // TODO duplicate constructBaseURL see NodeINFO
        val client = getKtorClient("$baseUrlInstance/api/$API_VERSION/")
        val semverV = version.toVersion(false)

        return when (semverV.major) {
            0 -> when (semverV.minor) {
                18 -> it.vercruysse.lemmyapi.v0.x18.x5.LemmyApiUniWrapper(client, semverV, baseUrlInstance, auth)
                19 -> when (semverV.patch) {
                    0, 1 -> it.vercruysse.lemmyapi.v0.x19.x0.LemmyApiUniWrapper(client, semverV, baseUrlInstance, auth)
                    2, 3 -> it.vercruysse.lemmyapi.v0.x19.x3.LemmyApiUniWrapper(client, semverV, baseUrlInstance, auth)
                    4, 5 -> it.vercruysse.lemmyapi.v0.x19.x4.LemmyApiUniWrapper(client, semverV, baseUrlInstance, auth)
                    6, 7, 8, 9, 10 -> it.vercruysse.lemmyapi.v0.x19.x6.LemmyApiUniWrapper(client, semverV, baseUrlInstance, auth)
                    11 -> it.vercruysse.lemmyapi.v0.x19.x11.LemmyApiUniWrapper(client, semverV, baseUrlInstance, auth)
                    else -> it.vercruysse.lemmyapi.v0.x19.x11.LemmyApiUniWrapper(client, semverV, baseUrlInstance, auth)
                }

                else -> throw NotSupportedException("Unsupported Lemmy minor version: $version")
            }

            else -> throw NotSupportedException("Unsupported Lemmy major version: $version")
        }
    }
}
