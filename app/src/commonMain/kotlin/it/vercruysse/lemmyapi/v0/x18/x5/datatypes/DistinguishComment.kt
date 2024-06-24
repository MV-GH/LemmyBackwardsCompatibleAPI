package it.vercruysse.lemmyapi.v0.x18.x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class DistinguishComment(
    val comment_id: CommentId,
    val distinguished: Boolean,
    val auth: String,
)
