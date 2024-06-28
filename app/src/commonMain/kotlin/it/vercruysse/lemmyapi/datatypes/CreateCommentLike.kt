package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@Serializable
data class CreateCommentLike(
    val comment_id: CommentId,
    val score: Int,
) : DatatypeRoot
