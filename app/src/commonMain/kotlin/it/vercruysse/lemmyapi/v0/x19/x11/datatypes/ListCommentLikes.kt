package it.vercruysse.lemmyapi.v0.x19.x11.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class ListCommentLikes(
    val comment_id: CommentId,
    val page: Long? = null,
    val limit: Long? = null,
)
