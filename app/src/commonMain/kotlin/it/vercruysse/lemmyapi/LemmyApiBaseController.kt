package it.vercruysse.lemmyapi

import io.github.z4kn4fein.semver.Version
import it.vercruysse.lemmyapi.datatypes.DeleteImageParams
import it.vercruysse.lemmyapi.datatypes.UploadImageResponse
import it.vercruysse.lemmyapi.utils.runCatchingPreservingCancellation

abstract class LemmyApiBaseController(actualVersion: Version, baseUrl: String, override var auth: String?) :
    LemmyApiBase(
        actualVersion,
        baseUrl,
        auth,
    ),
    UniRoutes,
    OldRoutes {

    suspend fun uploadAndApplyImage(
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
