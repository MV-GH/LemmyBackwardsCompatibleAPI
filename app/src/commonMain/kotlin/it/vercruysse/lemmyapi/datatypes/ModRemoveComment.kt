package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

@CommonParcelize
@Serializable
data class ModRemoveComment(
    val id: Long,
    val mod_person_id: PersonId,
    val comment_id: CommentId,
    val reason: String? = null,
    val removed: Boolean,
    val when_: String,
) : DatatypeRoot
