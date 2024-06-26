package it.vercruysse.lemmyapi.v0.x18.x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class CreateCommentReport(
    val comment_id: CommentId,
    val reason: String,
    val auth: String,
)
