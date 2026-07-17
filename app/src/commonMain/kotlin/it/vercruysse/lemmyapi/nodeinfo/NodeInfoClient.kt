package it.vercruysse.lemmyapi.nodeinfo

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import it.vercruysse.lemmyapi.IGNORE_UNKNOWN_KEYS_JSON
import it.vercruysse.lemmyapi.exception.NotSupportedException
import it.vercruysse.lemmyapi.installRequiredPlugins
import it.vercruysse.lemmyapi.utils.constructBaseUrl
import it.vercruysse.lemmyapi.utils.runCatchingPreservingCancellation

class NodeInfoClient(httpClient: HttpClient? = null) : AutoCloseable {
    private val ownsHttpClient = httpClient == null
    private val transport = httpClient ?: HttpClient()
    private val client = transport.withLemmyNodeInfoConfig()

    /**
     * Gets the NodeInfo document of an instance.
     */
    suspend fun getNodeInfo(instance: String): Result<NodeInfo> =
        runCatchingPreservingCancellation {
            client
                .get("${constructBaseUrl(instance)}/nodeinfo/2.0.json")
                .body<NodeInfo>()
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
     * Gets the version of a Lemmy instance.
     *
     * Returns a failure if NodeInfo retrieval fails or the instance is not Lemmy.
     */
    suspend fun getLemmyVersion(instance: String): Result<String> =
        getNodeInfo(instance).fold(
            onSuccess = ::getLemmyVersion,
            onFailure = { Result.failure(it) },
        )

    /**
     * Returns whether an instance supports the ActivityPub protocol.
     */
    suspend fun isFediverse(instance: String): Result<Boolean> =
        getNodeInfo(instance).map(::isFediverse)

    /**
     * Returns whether a NodeInfo document declares ActivityPub support.
     */
    fun isFediverse(nodeInfo: NodeInfo): Boolean = nodeInfo.protocols.contains("activitypub")

    /**
     * Returns whether an instance identifies its software as Lemmy.
     */
    suspend fun isLemmyInstance(instance: String): Result<Boolean> =
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
}

private fun HttpClient.withLemmyNodeInfoConfig(): HttpClient = config {
    installRequiredPlugins()
    expectSuccess = true

    install(ContentNegotiation) {
        json(IGNORE_UNKNOWN_KEYS_JSON)
    }
}
