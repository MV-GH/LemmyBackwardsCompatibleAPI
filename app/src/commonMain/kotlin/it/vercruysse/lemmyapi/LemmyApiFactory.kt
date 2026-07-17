package it.vercruysse.lemmyapi

import io.github.z4kn4fein.semver.toVersion
import io.ktor.client.*
import io.ktor.client.plugins.*
import it.vercruysse.lemmyapi.nodeinfo.NodeInfoClient
import it.vercruysse.lemmyapi.utils.constructBaseUrl
import it.vercruysse.lemmyapi.utils.runCatchingPreservingCancellation

class LemmyApiFactory(httpClient: HttpClient? = null) : AutoCloseable {
    private val ownsHttpClient = httpClient == null
    private val transport = httpClient ?: HttpClient()
    private val apiClient = transport.withLemmyApiConfig()
    private val nodeInfoClient = NodeInfoClient(transport)
    private val controllers = mutableListOf<LemmyApiBaseController>()

    private fun getKtorClient(baseUrl: String): HttpClient = apiClient.config {
        defaultRequest {
            url(baseUrl)
        }
    }

    private fun getApiVersion(version: io.github.z4kn4fein.semver.Version): String =
        if (version.major == 0) "v3" else "v4"

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
    ): Result<LemmyApiBaseController> =
        runCatchingPreservingCancellation {
            val baseUrlInstance = constructBaseUrl(instance) // TODO duplicate constructBaseURL see NodeINFO
            val semverV = version.toVersion(false)
            val apiVersion = getApiVersion(semverV)
            val client = getKtorClient("$baseUrlInstance/api/$apiVersion/")

            try {
                LemmyApiWrapperFactory.create(client, semverV, version, baseUrlInstance, auth).also(controllers::add)
            } catch (throwable: Throwable) {
                client.close()
                throw throwable
            }
        }

    /**
     * Closes clients derived by this factory. A supplied HTTP client remains caller-owned.
     */
    override fun close() {
        controllers.forEach(LemmyApiBaseController::close)
        controllers.clear()
        nodeInfoClient.close()
        apiClient.close()
        if (ownsHttpClient) {
            transport.close()
        }
    }
}
