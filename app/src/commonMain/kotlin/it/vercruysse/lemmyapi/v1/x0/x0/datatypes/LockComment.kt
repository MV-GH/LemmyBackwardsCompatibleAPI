package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class LockComment(
    val comment_id: CommentId,
    val locked: Boolean,
    val reason: String,
)
