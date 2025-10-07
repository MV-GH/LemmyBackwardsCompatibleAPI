package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class ModLockComment(
    val id: Long,
    val mod_person_id: PersonId,
    val comment_id: CommentId,
    val locked: Boolean,
    val reason: String,
    val published_at: String,
) : DatatypeRoot
