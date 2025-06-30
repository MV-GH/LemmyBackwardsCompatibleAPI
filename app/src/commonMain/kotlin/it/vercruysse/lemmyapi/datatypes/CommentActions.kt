package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class CommentActions(
    val person_id: PersonId,
    val comment_id: CommentId,
    val like_score: Int = 0,
    val liked: String? = null,
    val saved: String? = null,
): DatatypeRoot
