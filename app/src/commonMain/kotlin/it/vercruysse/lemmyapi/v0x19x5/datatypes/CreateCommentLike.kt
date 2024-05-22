package it.vercruysse.lemmyapi.v0x19x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class CreateCommentLike(
    val comment_id: CommentId,
    val score: Long,
)
