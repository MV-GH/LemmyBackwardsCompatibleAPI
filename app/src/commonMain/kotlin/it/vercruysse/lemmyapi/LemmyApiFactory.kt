package it.vercruysse.lemmyapi

import io.github.z4kn4fein.semver.toVersion
import io.ktor.client.*
import io.ktor.client.plugins.*
import io.ktor.client.request.*
import it.vercruysse.lemmyapi.nodeinfo.NodeInfoClient
import it.vercruysse.lemmyapi.utils.constructBaseUrl

class LemmyApiFactory(httpClient: HttpClient? = null) : AutoCloseable {
    private val ownsHttpClient = httpClient == null
    private val transport = httpClient ?: HttpClient()
    private val apiClient = transport.withLemmyApiConfig()
    private val nodeInfoClient = NodeInfoClient(transport)

    private fun getKtorClient(baseUrl: String): HttpClient =
        apiClient.config {
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
        nodeInfoClient.getLemmyVersion(instance).mapCatching { version ->
            create(instance, version, auth).getOrThrow()
        }

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
    fun create(
        instance: String,
        version: String,
        auth: String? = null,
    ): Result<LemmyApiBaseController> =
        runCatching {
            val baseUrlInstance = constructBaseUrl(instance) // TODO duplicate constructBaseURL see NodeINFO
            val semverV = version.toVersion(false)
            val apiVersion = getApiVersion(semverV)
            val client = getKtorClient("$baseUrlInstance/api/$apiVersion/")

            LemmyApiWrapperFactory.create(client, semverV, version, baseUrlInstance, auth)
        }

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
