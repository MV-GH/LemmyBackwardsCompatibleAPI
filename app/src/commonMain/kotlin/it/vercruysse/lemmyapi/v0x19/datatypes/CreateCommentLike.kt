package it.vercruysse.lemmyapi.v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class CreateCommentLike(
    val comment_id: CommentId,
    val score: Int,
)
