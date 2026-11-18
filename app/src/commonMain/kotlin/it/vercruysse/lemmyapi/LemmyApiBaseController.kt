package it.vercruysse.lemmyapi

import it.vercruysse.lemmyapi.datatypes.DeleteImageParams
import it.vercruysse.lemmyapi.datatypes.EditCustomEmoji
import it.vercruysse.lemmyapi.datatypes.GetCommunity
import it.vercruysse.lemmyapi.datatypes.ListCustomEmojis
import it.vercruysse.lemmyapi.datatypes.UploadImageResponse
import it.vercruysse.lemmyapi.enums.CommunityVisibility
import it.vercruysse.lemmyapi.enums.VersionTracker
import it.vercruysse.lemmyapi.exception.LemmyBadRequestException
import it.vercruysse.lemmyapi.exception.NotSupportedException
import it.vercruysse.lemmyapi.utils.getSupportedEntries
import it.vercruysse.lemmyapi.utils.runCatchingPreservingCancellation
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.withContext

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
            withContext(NonCancellable) {
                deleteMedia(DeleteImageParams(uploadResponse.delete_filename)).getOrNull()
            }
            throw e
        }
    }

    // Pre 1.0 edits overwrite every field, so fill the ones not given with the current values
    internal suspend fun withCurrentCustomEmoji(form: EditCustomEmoji): EditCustomEmoji {
        if (form.category != null && form.image_url != null && form.alt_text != null && form.keywords != null) return form
        val current = listCustomEmojis(ListCustomEmojis()).getOrThrow().custom_emojis
            .firstOrNull { it.custom_emoji.id == form.id }
            ?: throw IllegalArgumentException("Custom emoji ${form.id} not found")
        return form.copy(
            category = form.category ?: current.custom_emoji.category,
            image_url = form.image_url ?: current.custom_emoji.image_url,
            alt_text = form.alt_text ?: current.custom_emoji.alt_text,
            keywords = form.keywords ?: current.keywords.map { it.keyword },
        )
    }

    // Pre 1.0 Unlisted is the hidden flag. Returns the hidden state a visibility asks for, null to leave it as is.
    internal fun legacyHidden(visibility: CommunityVisibility?): Boolean? = when (visibility) {
        CommunityVisibility.Unlisted -> true
        CommunityVisibility.Public -> false
        CommunityVisibility.LocalOnly -> if (version.semanticVersion >= V0_19_4) false else null
        else -> null
    }

    // Only admins can hide a community pre 1.0, check it before anything is created or edited
    internal suspend fun checkCanChangeHidden() {
        if (!getMyUser().getOrThrow().local_user_view.local_user.admin) {
            throw LemmyBadRequestException(400, "not_an_admin", "Only admins can hide or unhide a community before Lemmy 1.0")
        }
    }

    internal suspend fun isHidden(communityId: Long): Boolean =
        getCommunity(GetCommunity(id = communityId)).getOrThrow().community_view.community.visibility == CommunityVisibility.Unlisted
}
