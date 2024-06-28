package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@Serializable
data class DistinguishComment(
    val comment_id: CommentId,
    val distinguished: Boolean,
) : DatatypeRoot
