package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class CommentActions(
    val person_id: PersonId,
    val comment_id: CommentId,
    val like_score: Long? = null,
    val liked: String? = null,
    val saved: String? = null,
)
