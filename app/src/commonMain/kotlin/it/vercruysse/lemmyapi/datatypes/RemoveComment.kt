package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

@CommonParcelize
@Serializable
data class RemoveComment(
    val comment_id: CommentId,
    val removed: Boolean,
    val reason: String,
    /** Added in Lemmy 1.0.0 */
    val remove_children: Boolean? = null,
) : DatatypeRoot
