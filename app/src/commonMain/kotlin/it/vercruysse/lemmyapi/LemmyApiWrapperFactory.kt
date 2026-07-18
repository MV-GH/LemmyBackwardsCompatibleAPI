package it.vercruysse.lemmyapi

import io.ktor.client.HttpClient
import it.vercruysse.lemmyapi.exception.NotSupportedException

internal object LemmyApiWrapperFactory {

    private fun getApiVersion(version: io.github.z4kn4fein.semver.Version): String =
        if (version.major == 0) "v3" else "v4"

    fun create(
        client: HttpClient,
        instance: LemmyInstance,
        version: LemmyVersion,
        auth: LemmyAuth,
        versionPolicy: VersionPolicy,
    ): LemmyApiBaseController {
        val baseUrlInstance = instance.baseUrl
        val semanticVersion = version.semanticVersion
        val apiBaseUrl = "$baseUrlInstance/api/${getApiVersion(semanticVersion)}"
        val token = auth.token

        return when (semanticVersion.major) {
            0 -> when (semanticVersion.minor) {
                18 -> if (semanticVersion.patch <= 5 || versionPolicy == VersionPolicy.LatestKnownCompatible) {
                    it.vercruysse.lemmyapi.v0.x18.x5.LemmyApiUniWrapper(client, apiBaseUrl, instance, version, baseUrlInstance, token)
                } else {
                    throw NotSupportedException("Unsupported Lemmy version: $version")
                }

                19 -> when (semanticVersion.patch) {
                    0, 1 -> it.vercruysse.lemmyapi.v0.x19.x0.LemmyApiUniWrapper(client, apiBaseUrl, instance, version, baseUrlInstance, token)

                    2, 3 -> it.vercruysse.lemmyapi.v0.x19.x3.LemmyApiUniWrapper(client, apiBaseUrl, instance, version, baseUrlInstance, token)

                    4, 5 -> it.vercruysse.lemmyapi.v0.x19.x4.LemmyApiUniWrapper(client, apiBaseUrl, instance, version, baseUrlInstance, token)

                    6, 7, 8, 9, 10 -> it.vercruysse.lemmyapi.v0.x19.x6.LemmyApiUniWrapper(client, apiBaseUrl, instance, version, baseUrlInstance, token)

                    11 -> it.vercruysse.lemmyapi.v0.x19.x11.LemmyApiUniWrapper(client, apiBaseUrl, instance, version, baseUrlInstance, token)

                    else -> if (versionPolicy == VersionPolicy.LatestKnownCompatible) {
                        it.vercruysse.lemmyapi.v0.x19.x11.LemmyApiUniWrapper(client, apiBaseUrl, instance, version, baseUrlInstance, token)
                    } else {
                        throw NotSupportedException("Unsupported Lemmy version: $version")
                    }
                }

                else -> throw NotSupportedException("Unsupported Lemmy minor version: $version")
            }

            1 -> if (
                versionPolicy == VersionPolicy.LatestKnownCompatible || semanticVersion.minor == 0
            ) {
                it.vercruysse.lemmyapi.v1.x0.x0.LemmyApiUniWrapper(client, apiBaseUrl, instance, version, token)
            } else {
                throw NotSupportedException("Unsupported Lemmy version: $version")
            }

            else -> throw NotSupportedException("Unsupported Lemmy major version: $version")
        }
    }
}
