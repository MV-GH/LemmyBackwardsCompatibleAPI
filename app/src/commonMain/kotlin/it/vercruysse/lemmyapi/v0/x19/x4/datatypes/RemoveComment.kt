package it.vercruysse.lemmyapi.v0.x19.x4.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class RemoveComment(
    val comment_id: CommentId,
    val removed: Boolean,
    val reason: String? = null,
)
