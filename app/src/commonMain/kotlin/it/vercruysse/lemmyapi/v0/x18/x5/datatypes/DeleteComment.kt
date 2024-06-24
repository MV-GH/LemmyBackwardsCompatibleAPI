package it.vercruysse.lemmyapi.v0.x18.x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class DeleteComment(
    val comment_id: CommentId,
    val deleted: Boolean,
    val auth: String,
)
