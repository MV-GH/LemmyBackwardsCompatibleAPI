package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class CommentActions(
    val like_score: Long? = null,
    val liked_at: String? = null,
    val saved_at: String? = null,
)
