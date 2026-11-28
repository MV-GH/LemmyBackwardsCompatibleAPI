package it.vercruysse.lemmyapi.utils

import it.vercruysse.lemmyapi.datatypes.CommentSlimView
import it.vercruysse.lemmyapi.datatypes.CommentView
import it.vercruysse.lemmyapi.datatypes.PagedResponse

/**
 * Pre 1.0 Lemmy has no slim comments endpoint, so the slim view is taken from the full comment view.
 */
internal fun PagedResponse<CommentView>.toSlim(): PagedResponse<CommentSlimView> = PagedResponse(
    items.map {
        CommentSlimView(
            comment = it.comment,
            creator = it.creator,
            comment_actions = it.comment_actions,
            person_actions = it.person_actions,
            creator_is_admin = it.creator_is_admin,
            can_mod = it.can_mod,
            creator_banned = it.creator_banned,
            creator_is_moderator = it.creator_is_moderator,
            creator_banned_from_community = it.creator_banned_from_community,
        )
    },
    next_page,
    prev_page,
)
