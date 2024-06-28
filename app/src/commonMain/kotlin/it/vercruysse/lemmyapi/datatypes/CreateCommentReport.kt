package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@Serializable
data class CreateCommentReport(
    val comment_id: CommentId,
    val reason: String,
) : DatatypeRoot
