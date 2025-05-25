package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class PostActions(
    val post_id: PostId,
    val person_id: PersonId,
    val read: String? = null,
    val read_comments: String? = null,
    val read_comments_amount: Long? = null,
    val saved: String? = null,
    val liked: String? = null,
    val like_score: Long? = null,
    val hidden: String? = null,
): DatatypeRoot
