package it.vercruysse.lemmyapi.v0x19x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class ListCommentLikes(
    val comment_id: CommentId,
    val page: Long? = null,
    val limit: Long? = null,
)
