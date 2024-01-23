package it.vercruysse.lemmyapi.v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class ListCommentLikes(
    val comment_id: CommentId,
    val page: Int? = null,
    val limit: Int? = null,
)
