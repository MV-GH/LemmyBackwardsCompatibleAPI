package it.vercruysse.lemmyapi

import io.ktor.client.*
import it.vercruysse.lemmyapi.nodeinfo.NodeInfoClient
import it.vercruysse.lemmyapi.utils.runCatchingPreservingCancellation

class LemmyApiClient(
    httpClient: HttpClient? = null,
    val options: LemmyApiOptions = LemmyApiOptions(),
) : AutoCloseable {
    private val ownsHttpClient = httpClient == null
    private val transport = httpClient ?: HttpClient()
    private val apiClient = transport.withLemmyApiConfig(options)
    private val nodeInfoClient = NodeInfoClient(transport, options)

    /**
     * Connects to an instance after discovering its Lemmy version.
     *
     * Returns a failure if the instance isn't available, isn't a Lemmy host, or isn't supported.
     *
     * Use the Feature Flags before using certain endpoints as they can be or not available depending
     * on the version of the Lemmy Server instance.
     */

    suspend fun connect(
        instance: LemmyInstance,
        auth: LemmyAuth = LemmyAuth.Anonymous,
    ): Result<LemmyApiBaseController> =
        nodeInfoClient.getLemmyVersion(instance).fold(
            onSuccess = { version -> connectForVersion(instance, LemmyVersion(version), auth) },
            onFailure = { Result.failure(it) },
        )

    /**
     * Connects to an instance with a known Lemmy version.
     *
     * Returns a failure if the version is invalid or unsupported.
     *
     * Be warned that this function assumes that the instance and the version are correct.
     *
     * Use the Feature Flags before using certain endpoints as they can be or not available depending
     * on the version of the Lemmy Server instance.
     */
    fun connectForVersion(
        instance: LemmyInstance,
        version: LemmyVersion,
        auth: LemmyAuth = LemmyAuth.Anonymous,
    ): Result<LemmyApiBaseController> = runCatchingPreservingCancellation {
        LemmyApiWrapperFactory.create(
            apiClient,
            instance,
            version,
            auth,
            options.versionPolicy,
        )
    }

    /**
     * Closes clients owned by this client. A supplied HTTP client remains caller-owned.
     * Controllers connected by this client must not outlive it.
     */
    override fun close() {
        nodeInfoClient.close()
        apiClient.close()
        if (ownsHttpClient) {
            transport.close()
        }
    }
}
