package it.vercruysse.lemmyapi

import io.ktor.client.*
import it.vercruysse.lemmyapi.nodeinfo.NodeInfoClient
import it.vercruysse.lemmyapi.utils.runCatchingPreservingCancellation

class LemmyApiFactory(httpClient: HttpClient? = null) : AutoCloseable {
    private val ownsHttpClient = httpClient == null
    private val transport = httpClient ?: HttpClient()
    private val apiClient = transport.withLemmyApiConfig()
    private val nodeInfoClient = NodeInfoClient(transport)

    /**
     * Creates a controller after discovering the Lemmy version.
     *
     * Returns a failure if the instance isn't available, isn't a Lemmy host, or isn't supported.
     *
     * Use the Feature Flags before using certain endpoints as they can be or not available depending
     * on the version of the Lemmy Server instance.
     */

    suspend fun create(
        instance: String,
        auth: String? = null,
    ): Result<LemmyApiBaseController> =
        nodeInfoClient.getLemmyVersion(instance).fold(
            onSuccess = { version -> createForVersion(instance, version, auth) },
            onFailure = { Result.failure(it) },
        )

    /**
     * Creates a controller for a known Lemmy version.
     *
     * Returns a failure if the version is invalid or unsupported.
     *
     * Be warned that this function assumes that the instance and the version are correct.
     *
     * Use the Feature Flags before using certain endpoints as they can be or not available depending
     * on the version of the Lemmy Server instance.
     */
    fun createForVersion(
        instance: String,
        version: String,
        auth: String? = null,
    ): Result<LemmyApiBaseController> = runCatchingPreservingCancellation {
        LemmyApiWrapperFactory.create(
            apiClient,
            instance,
            version,
            auth,
        )
    }

    /**
     * Closes clients owned by this factory. A supplied HTTP client remains caller-owned.
     * Controllers created by this factory must not outlive it.
     */
    override fun close() {
        nodeInfoClient.close()
        apiClient.close()
        if (ownsHttpClient) {
            transport.close()
        }
    }
}
