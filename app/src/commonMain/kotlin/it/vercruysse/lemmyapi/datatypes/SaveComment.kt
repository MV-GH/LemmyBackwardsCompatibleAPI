package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@Serializable
data class SaveComment(
    val comment_id: CommentId,
    val save: Boolean,
) : DatatypeRoot
