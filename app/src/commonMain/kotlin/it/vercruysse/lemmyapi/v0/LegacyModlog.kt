package it.vercruysse.lemmyapi.v0

import it.vercruysse.lemmyapi.datatypes.Comment
import it.vercruysse.lemmyapi.datatypes.Community
import it.vercruysse.lemmyapi.datatypes.GetModlog
import it.vercruysse.lemmyapi.datatypes.Modlog
import it.vercruysse.lemmyapi.datatypes.ModlogView
import it.vercruysse.lemmyapi.datatypes.Person
import it.vercruysse.lemmyapi.datatypes.Post
import it.vercruysse.lemmyapi.enums.ModlogKind
import it.vercruysse.lemmyapi.utils.sortableTimestamp
import it.vercruysse.lemmyapi.v0.enums.ModlogActionType

/**
 * Helpers to flatten the per-category modlog of pre 1.0 Lemmy into the 1.0 [ModlogView] list.
 *
 * Pre 1.0 every action type lives in its own table, so [Modlog.id] is only unique per [Modlog.kind].
 */
internal object LegacyModlog {
    fun view(
        id: Long,
        kind: ModlogKind,
        isRevert: Boolean,
        publishedAt: String,
        moderator: Person?,
        reason: String? = null,
        expiresAt: String? = null,
        targetPerson: Person? = null,
        targetCommunity: Community? = null,
        targetPost: Post? = null,
        targetComment: Comment? = null,
    ): ModlogView = ModlogView(
        modlog = Modlog(
            id = id,
            kind = kind,
            is_revert = isRevert,
            reason = reason,
            expires_at = expiresAt,
            published_at = publishedAt,
        ),
        moderator = moderator,
        target_person = targetPerson,
        target_community = targetCommunity,
        target_post = targetPost,
        target_comment = targetComment,
    )

    /** The requested type only exists from 1.0, so pre 1.0 there is nothing to return. */
    fun hasNoLegacyType(form: GetModlog): Boolean = form.type_ != null && ModlogActionType.fromUniNullable(form.type_) == null

    /** Client side filters for the [GetModlog] fields older servers ignore. */
    fun matches(view: ModlogView, form: GetModlog): Boolean =
        (form.post_id == null || view.target_post?.id == form.post_id) &&
            (form.comment_id == null || view.target_comment?.id == form.comment_id)

    /** Merges the categories newest first, like the 1.0 modlog. */
    fun sort(views: List<ModlogView>): List<ModlogView> = views.sortedByDescending { sortableTimestamp(it.modlog.published_at) }
}
