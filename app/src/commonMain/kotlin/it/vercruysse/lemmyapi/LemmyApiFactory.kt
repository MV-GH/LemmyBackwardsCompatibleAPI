package it.vercruysse.lemmyapi

import io.github.z4kn4fein.semver.toVersion
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.*
import io.ktor.client.request.*
import it.vercruysse.lemmyapi.dto.NodeInfo
import it.vercruysse.lemmyapi.exception.NotSupportedException
import it.vercruysse.lemmyapi.utils.constructBaseUrl

class LemmyApiFactory(httpClient: HttpClient? = null) : AutoCloseable {
    private val ownsHttpClient = httpClient == null
    private val transport = httpClient ?: HttpClient()
    private val apiClient = transport.withLemmyApiConfig()
    private val nodeInfoClient = transport.withLemmyNodeInfoConfig()

    /**
     * Adds the instance API base URL to the required client configuration.
     */
    private fun getKtorClient(baseUrl: String): HttpClient =
        apiClient.config {
            defaultRequest {
                url(baseUrl)
            }
        }

    /**
     * Gets the node info of a Lemmy instance
     */
    suspend fun getNodeInfo(instance: String): Result<NodeInfo> =
        runCatching {
            nodeInfoClient
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
            isFediverse(nodeResult.getOrThrow())
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
     * Creates a controller after discovering the Lemmy version.
     *
     * Throws several errors if the Instance isn't available or a Lemmy host or supported.
     *
     * Use the Feature Flags before using certain endpoints as they can be or not available depending
     * on the version of the Lemmy Server instance.
     */

    suspend fun create(
        instance: String,
        auth: String? = null,
    ): LemmyApiBaseController {
        val version = getLemmyVersion(instance)
        return create(instance, version, auth)
    }

    /**
     * Creates a controller for a known Lemmy version.
     *
     * @throws NotSupportedException if the instance isn't supported.
     *
     * Be warned that this function assumes that the instance and the version are correct.
     *
     * Use the Feature Flags before using certain endpoints as they can be or not available depending
     * on the version of the Lemmy Server instance.
     */
    fun create(
        instance: String,
        version: String,
        auth: String? = null,
    ): LemmyApiBaseController {
        val baseUrlInstance = constructBaseUrl(instance) // TODO duplicate constructBaseURL see NodeINFO
        val semverV = version.toVersion(false)
        val apiVersion = getApiVersion(semverV)
        val client = getKtorClient("$baseUrlInstance/api/$apiVersion/")

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

            1 -> it.vercruysse.lemmyapi.v1.x0.x0.LemmyApiUniWrapper(client, semverV, baseUrlInstance, auth)

            else -> throw NotSupportedException("Unsupported Lemmy major version: $version")
        }
    }

    private fun getApiVersion(version: io.github.z4kn4fein.semver.Version): String = if (version.major == 0) "v3" else "v4"

    /**
     * Closes clients derived by this factory. A supplied HTTP client remains caller-owned.
     */
    override fun close() {
        nodeInfoClient.close()
        apiClient.close()
        if (ownsHttpClient) {
            transport.close()
        }
    }
}
