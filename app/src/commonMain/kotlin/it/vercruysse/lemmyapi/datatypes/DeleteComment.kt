package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@Serializable
data class DeleteComment(
    val comment_id: CommentId,
    val deleted: Boolean,
) : DatatypeRoot
