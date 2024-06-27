package it.vercruysse.lemmyapi.v0.x19.x3.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class PurgeComment(
    val comment_id: CommentId,
    val reason: String? = null,
)
