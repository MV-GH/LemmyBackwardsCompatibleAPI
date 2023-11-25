package it.vercruysse.lemmyapi.v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class SaveComment(
    val comment_id: CommentId,
    val save: Boolean,
    val auth: String,
)
