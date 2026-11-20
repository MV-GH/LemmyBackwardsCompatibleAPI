package it.vercruysse.lemmyapi

import io.ktor.client.*
import it.vercruysse.lemmyapi.exception.LemmyConnectException
import it.vercruysse.lemmyapi.nodeinfo.NodeInfoClient
import it.vercruysse.lemmyapi.utils.runCatchingPreservingCancellation

class LemmyApiClient(
    httpClient: HttpClient? = null,
    val options: LemmyApiOptions = LemmyApiOptions(),
) : AutoCloseable {
    private val ownsHttpClient = httpClient == null
    private val transport = httpClient ?: HttpClient()
    private val apiClient = transport.withLemmyApiConfig(options)

    /**
     * Client for querying NodeInfo.
     *
     * Do not use this client after this API client has been closed.
     */
    val nodeInfoClient = NodeInfoClient(transport, options)

    /**
     * Connects to an instance after discovering its Lemmy version.
     *
     * Fails with a [LemmyConnectException]:
     * - [LemmyConnectException.NodeInfoUnavailable] when the NodeInfo document can't be loaded or read,
     * - [LemmyConnectException.NotLemmy] when the instance runs other software,
     * - [LemmyConnectException.InvalidVersion] when the reported version isn't a version number,
     * - [LemmyConnectException.UnsupportedVersion] when the version isn't supported.
     *
     * Use the Feature Flags before using certain endpoints as they can be or not available depending
     * on the version of the Lemmy Server instance.
     */
    suspend fun connect(
        instance: LemmyInstance,
        auth: LemmyAuth = LemmyAuth.Anonymous,
    ): Result<LemmyApiBaseController> {
        val nodeInfo = nodeInfoClient.getNodeInfo(instance)
            .getOrElse { return Result.failure(LemmyConnectException.NodeInfoUnavailable(it)) }
        if (!nodeInfoClient.isLemmyInstance(nodeInfo)) {
            return Result.failure(LemmyConnectException.NotLemmy(nodeInfo))
        }
        val rawVersion = nodeInfo.software.version
        val version = try {
            LemmyVersion(rawVersion)
        } catch (exception: IllegalArgumentException) {
            return Result.failure(LemmyConnectException.InvalidVersion(rawVersion, exception))
        }
        return connectForVersion(instance, auth, version)
    }

    /**
     * Connects to an instance with a known Lemmy version.
     *
     * Fails with [LemmyConnectException.UnsupportedVersion] if the version is unsupported.
     *
     * Be warned that this function assumes that the instance and the version are correct.
     *
     * Use the Feature Flags before using certain endpoints as they can be or not available depending
     * on the version of the Lemmy Server instance.
     */
    fun connectForVersion(
        instance: LemmyInstance,
        auth: LemmyAuth = LemmyAuth.Anonymous,
        version: LemmyVersion,
    ): Result<LemmyApiBaseController> = runCatchingPreservingCancellation {
        LemmyApiWrapperFactory.create(
            apiClient,
            instance,
            version,
            auth,
            options.versionPolicy,
            options.onAuthRejected,
        )
    }

    /**
     * Connects to an instance with a known Lemmy version.
     *
     * Fails with [LemmyConnectException.UnsupportedVersion] if the version is unsupported.
     *
     * Be warned that this function assumes that the instance and the version are correct.
     *
     * Use the Feature Flags before using certain endpoints as they can be or not available depending
     * on the version of the Lemmy Server instance.
     */
    fun connectForVersion(
        instance: LemmyInstance,
        version: LemmyVersion,
    ): Result<LemmyApiBaseController> = connectForVersion(instance, LemmyAuth.Anonymous, version)

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
