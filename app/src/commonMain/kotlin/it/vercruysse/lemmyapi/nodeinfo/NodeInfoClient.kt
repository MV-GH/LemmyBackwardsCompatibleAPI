package it.vercruysse.lemmyapi.nodeinfo

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.request.*
import io.ktor.http.HttpStatusCode
import it.vercruysse.lemmyapi.LemmyApiOptions
import it.vercruysse.lemmyapi.LemmyInstance
import it.vercruysse.lemmyapi.exception.NotSupportedException
import it.vercruysse.lemmyapi.installRequiredPlugins
import it.vercruysse.lemmyapi.utils.runCatchingPreservingCancellation

class NodeInfoClient(
    httpClient: HttpClient? = null,
    options: LemmyApiOptions = LemmyApiOptions(),
) : AutoCloseable {
    private val ownsHttpClient = httpClient == null
    private val transport = httpClient ?: HttpClient()
    private val client = transport.withLemmyNodeInfoConfig(options)

    /**
     * Gets the NodeInfo document of an instance.
     */
    suspend fun getNodeInfo(instance: Instance): Result<NodeInfo> = getNodeInfoQuick(instance)

    /**
     * Gets the NodeInfo document from the conventional quick endpoints.
     *
     * Avoids some latency by skipping the well-known discovery document,
     * but may fail if the instance does not support the conventional endpoints.
     */
    suspend fun getNodeInfoQuick(instance: Instance): Result<NodeInfo> =
        runCatchingPreservingCancellation {
            try {
                getNodeInfoAt("${instance.baseUrl}$NODEINFO_2_0_PATH")
            } catch (exception: ClientRequestException) {
                if (exception.response.status == HttpStatusCode.NotFound) {
                    getNodeInfoAt("${instance.baseUrl}$NODEINFO_2_1_PATH")
                } else {
                    throw exception
                }
            }
        }

    /**
     * Gets the NodeInfo document by following the instance's well-known discovery document.
     */
    suspend fun getNodeInfoSafe(instance: Instance): Result<NodeInfo> =
        runCatchingPreservingCancellation {
            val wellKnown = client
                .get("${instance.baseUrl}$WELL_KNOWN_PATH")
                .body<NodeInfoWellKnown>()
            getNodeInfoAt(wellKnown.nodeInfoHref())
        }

    /**
     * Gets the software version from a NodeInfo document.
     */
    fun getVersion(nodeInfo: NodeInfo): String = nodeInfo.software.version

    /**
     * Gets the Lemmy version from a NodeInfo document.
     *
     * Returns a failure if the document does not describe a Lemmy instance.
     */
    fun getLemmyVersion(nodeInfo: NodeInfo): Result<String> =
        if (isLemmyInstance(nodeInfo)) {
            Result.success(getVersion(nodeInfo))
        } else {
            Result.failure(NotSupportedException("Not a Lemmy instance"))
        }

    /**
     * Gets the version of an instance.
     *
     * Returns a failure if NodeInfo retrieval fails.
     */
    suspend fun getVersion(instance: Instance): Result<String> =
        getNodeInfo(instance).fold(
            onSuccess = { Result.success(getVersion(it)) },
            onFailure = { Result.failure(it) },
        )

    /**
     * Gets the version of a Lemmy instance.
     *
     * Returns a failure if NodeInfo retrieval fails or the instance is not Lemmy.
     */
    suspend fun getLemmyVersion(lemmyInstance: LemmyInstance): Result<String> =
        getNodeInfo(lemmyInstance).fold(
            onSuccess = ::getLemmyVersion,
            onFailure = { Result.failure(it) },
        )

    /**
     * Returns whether an instance supports the ActivityPub protocol.
     */
    suspend fun isFediverse(instance: Instance): Result<Boolean> =
        getNodeInfo(instance).map(::isFediverse)

    /**
     * Returns whether a NodeInfo document declares ActivityPub support.
     */
    fun isFediverse(nodeInfo: NodeInfo): Boolean = nodeInfo.protocols.contains("activitypub")

    /**
     * Returns whether an instance identifies its software as Lemmy.
     */
    suspend fun isLemmyInstance(instance: LemmyInstance): Result<Boolean> =
        getNodeInfo(instance).map(::isLemmyInstance)

    /**
     * Returns whether a NodeInfo document identifies its software as Lemmy.
     */
    fun isLemmyInstance(nodeInfo: NodeInfo): Boolean = nodeInfo.software.name.lowercase() == "lemmy"

    /**
     * Closes the configured client and any transport created by this client.
     */
    override fun close() {
        client.close()
        if (ownsHttpClient) {
            transport.close()
        }
    }

    private fun HttpClient.withLemmyNodeInfoConfig(options: LemmyApiOptions): HttpClient = config {
        installRequiredPlugins(options)
        expectSuccess = true
    }

    private suspend fun getNodeInfoAt(url: String): NodeInfo = client.get(url).body()

    private fun NodeInfoWellKnown.nodeInfoHref(): String =
        links.firstOrNull { it.rel == NODEINFO_2_1_RELATION }?.href
            ?: links.firstOrNull { it.rel == NODEINFO_2_0_RELATION }?.href
            ?: throw NotSupportedException(
                "NodeInfo discovery document does not contain a supported 2.0 or 2.1 link",
            )

    private companion object {
        const val WELL_KNOWN_PATH = "/.well-known/nodeinfo"
        const val NODEINFO_2_0_PATH = "/nodeinfo/2.0.json"
        const val NODEINFO_2_1_PATH = "/nodeinfo/2.1.json"
        const val NODEINFO_2_0_RELATION = "http://nodeinfo.diaspora.software/ns/schema/2.0"
        const val NODEINFO_2_1_RELATION = "http://nodeinfo.diaspora.software/ns/schema/2.1"
    }
}
