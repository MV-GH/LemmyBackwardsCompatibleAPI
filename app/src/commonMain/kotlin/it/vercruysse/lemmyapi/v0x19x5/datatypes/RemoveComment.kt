package it.vercruysse.lemmyapi.v0x19x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class RemoveComment(
    val comment_id: CommentId,
    val removed: Boolean,
    val reason: String? = null,
)
