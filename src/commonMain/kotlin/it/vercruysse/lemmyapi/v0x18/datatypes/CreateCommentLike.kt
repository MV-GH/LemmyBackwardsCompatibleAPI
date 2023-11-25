package it.vercruysse.lemmyapi.v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class CreateCommentLike(
    val comment_id: CommentId,
    val score: Int,
    val auth: String,
)
