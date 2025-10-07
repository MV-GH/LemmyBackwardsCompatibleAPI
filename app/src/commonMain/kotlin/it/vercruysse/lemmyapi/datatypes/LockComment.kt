package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class LockComment(
    val comment_id: CommentId,
    val locked: Boolean,
    val reason: String,
) : DatatypeRoot
