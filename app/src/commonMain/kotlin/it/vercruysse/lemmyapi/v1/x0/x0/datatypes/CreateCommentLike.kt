package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class CreateCommentLike(
    val comment_id: CommentId,
    val is_upvote: Boolean? = null,
)
