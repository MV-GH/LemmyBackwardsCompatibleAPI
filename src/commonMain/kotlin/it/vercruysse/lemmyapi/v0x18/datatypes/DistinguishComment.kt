package it.vercruysse.lemmyapi.v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class DistinguishComment(
    val comment_id: CommentId,
    val distinguished: Boolean,
    val auth: String,
)
