package it.vercruysse.lemmyapi

import io.github.z4kn4fein.semver.Version
import io.ktor.client.HttpClient
import it.vercruysse.lemmyapi.exception.NotSupportedException

internal object LemmyApiWrapperFactory {
    fun create(
        client: HttpClient,
        version: Version,
        versionString: String,
        baseUrlInstance: String,
        auth: String?,
    ): LemmyApiBaseController =
        when (version.major) {
            0 -> when (version.minor) {
                18 -> it.vercruysse.lemmyapi.v0.x18.x5.LemmyApiUniWrapper(client, version, baseUrlInstance, auth)

                19 -> when (version.patch) {
                    0, 1 -> it.vercruysse.lemmyapi.v0.x19.x0.LemmyApiUniWrapper(client, version, baseUrlInstance, auth)

                    2, 3 -> it.vercruysse.lemmyapi.v0.x19.x3.LemmyApiUniWrapper(client, version, baseUrlInstance, auth)

                    4, 5 -> it.vercruysse.lemmyapi.v0.x19.x4.LemmyApiUniWrapper(client, version, baseUrlInstance, auth)

                    6, 7, 8, 9, 10 -> it.vercruysse.lemmyapi.v0.x19.x6.LemmyApiUniWrapper(client, version, baseUrlInstance, auth)

                    11 -> it.vercruysse.lemmyapi.v0.x19.x11.LemmyApiUniWrapper(client, version, baseUrlInstance, auth)

                    // Newer 0.19 patch releases use the latest known compatible wrapper.
                    else -> it.vercruysse.lemmyapi.v0.x19.x11.LemmyApiUniWrapper(client, version, baseUrlInstance, auth)
                }

                else -> throw NotSupportedException("Unsupported Lemmy minor version: $versionString")
            }

            1 -> it.vercruysse.lemmyapi.v1.x0.x0.LemmyApiUniWrapper(client, version, baseUrlInstance, auth)

            else -> throw NotSupportedException("Unsupported Lemmy major version: $versionString")
        }
}
