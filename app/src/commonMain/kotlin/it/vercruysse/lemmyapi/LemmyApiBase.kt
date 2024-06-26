package it.vercruysse.lemmyapi

import io.github.z4kn4fein.semver.Version
import io.ktor.client.*
import it.vercruysse.lemmyapi.dto.NodeInfo
import it.vercruysse.lemmyapi.dto.VersionTracker
import it.vercruysse.lemmyapi.dto.getSupportedEntries
import it.vercruysse.lemmyapi.exception.NotSupportedException
import it.vercruysse.lemmyapi.pictrs.PictrsService

// Wanted to keep this as an interface, but interfaces can't keep state
abstract class LemmyApiBase(httpClient: HttpClient, val version: Version, val baseUrl: String, override var auth: String?) :
    PictrsService(httpClient, auth),
    OldRoutes {
    @Suppress("PropertyName")
    val FF = FeatureFlags(version)

    /**
     * Returns the supported entries enum entries for this API version.
     *
     * It is possible that this list is empty, such case means this type is not used at all in a newer version
     * Or doesn't exist in the older version.
     *
     * @return A list of supported entries
     */
    inline fun <reified T> getSupportedEntries(): List<T> where T : Enum<T>, T : VersionTracker = getSupportedEntries(version)

    suspend fun getNodeInfo(): Result<NodeInfo> = LemmyApi.getNodeInfo(baseUrl)

    protected inline fun <reified T> notSupported(): Result<T> = Result.failure(
        NotSupportedException(
            "This endpoint is not supported on this version of Lemmy: $version, use a FeatureFlag to check if it's supported",
        ),
    )
}
