package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class RemoveComment(
    val comment_id: CommentId,
    val removed: Boolean,
    val reason: String? = null,
)
