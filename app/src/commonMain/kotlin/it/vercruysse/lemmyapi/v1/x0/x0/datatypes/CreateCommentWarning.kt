package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

// TODO no endpoint yet

@Serializable
internal data class CreateCommentWarning(
    val comment_id: CommentId,
    val reason: String,
)
