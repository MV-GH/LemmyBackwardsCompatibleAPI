package it.vercruysse.lemmyapi

import it.vercruysse.lemmyapi.datatypes.DeleteImageParams
import it.vercruysse.lemmyapi.datatypes.UploadImageResponse
import it.vercruysse.lemmyapi.enums.VersionTracker
import it.vercruysse.lemmyapi.exception.NotSupportedException
import it.vercruysse.lemmyapi.utils.getSupportedEntries
import it.vercruysse.lemmyapi.utils.runCatchingPreservingCancellation

abstract class LemmyApiBaseController(
    val instance: LemmyInstance,
    val version: LemmyVersion,
    protected open var auth: String?,
) : UniRoutes, OldRoutes {

    @Suppress("PropertyName")
    val FF = FeatureFlags(version)

    fun updateAuth(auth: LemmyAuth) {
        this.auth = auth.token
    }

    fun clearAuth() {
        auth = null
    }

    /**
     * Returns the supported entries enum entries for this API version.
     *
     * It is possible that this list is empty, such case means this type is not used at all in a newer version
     * Or doesn't exist in the older version.
     *
     * @return A list of supported entries
     */
    inline fun <reified T> getSupportedEntries(): List<T> where T : Enum<T>, T : VersionTracker =
        getSupportedEntries(version.semanticVersion)

    protected inline fun <reified T> notSupported(): Result<T> = Result.failure(
        NotSupportedException(
            "This endpoint is not supported on this version of Lemmy: $version, use a FeatureFlag to check if it's supported",
        ),
    )

    // Needed for pre 1.0.0 controllers
    internal suspend fun uploadAndApplyImage(
        image: ByteArray,
        applyImage: suspend (String) -> Result<Unit>,
    ): Result<UploadImageResponse> = runCatchingPreservingCancellation {
        val uploadResponse = uploadImage(image).getOrThrow()
        try {
            applyImage(uploadResponse.image_url).getOrThrow()
            uploadResponse
        } catch (e: Throwable) {
            deleteMedia(DeleteImageParams(uploadResponse.delete_filename)).getOrNull()
            throw e
        }
    }
}
