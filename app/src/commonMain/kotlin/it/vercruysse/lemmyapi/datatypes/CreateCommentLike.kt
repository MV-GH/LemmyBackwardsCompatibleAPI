package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

@CommonParcelize
@Serializable
data class CreateCommentLike(
    val comment_id: CommentId,
    // TODO: changed
    val score: Int,
) : DatatypeRoot
