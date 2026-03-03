package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.v1.x0.x0.datatypes.CommentId
import kotlinx.serialization.Serializable

// TODO no endpoint yet

@CommonParcelize
@Serializable
data class CreateCommentWarning(
    val comment_id: CommentId,
    val reason: String,
) : DatatypeRoot
