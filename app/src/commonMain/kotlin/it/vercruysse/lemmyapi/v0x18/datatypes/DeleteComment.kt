package it.vercruysse.lemmyapi.v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class DeleteComment(
    val comment_id: CommentId,
    val deleted: Boolean,
    val auth: String,
)
