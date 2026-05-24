package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class CommentActions(
    val like_score: Int = 0,
    val voted_at: String? = null,
    val saved_at: String? = null,
) : DatatypeRoot
