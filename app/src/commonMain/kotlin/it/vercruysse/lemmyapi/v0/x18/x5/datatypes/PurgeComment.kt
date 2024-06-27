package it.vercruysse.lemmyapi.v0.x18.x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class PurgeComment(
    val comment_id: CommentId,
    val reason: String? = null,
    val auth: String,
)
