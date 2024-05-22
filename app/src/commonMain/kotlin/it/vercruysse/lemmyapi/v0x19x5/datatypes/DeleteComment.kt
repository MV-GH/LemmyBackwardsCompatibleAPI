package it.vercruysse.lemmyapi.v0x19x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class DeleteComment(
    val comment_id: CommentId,
    val deleted: Boolean,
)
