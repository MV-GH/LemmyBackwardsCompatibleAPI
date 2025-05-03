package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class PostActions(
    val post_id: PostId,
    val person_id: PersonId,
    val read: String? = null,
    val read_comments: String? = null,
    val read_comments_amount: Long? = null,
    val saved: String? = null,
    val liked: String? = null,
    val like_score: Long? = null,
    val hidden: String? = null,
)
