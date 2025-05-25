package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

@CommonParcelize
@Serializable
data class AdminPurgeComment(
    val id: AdminPurgeCommentId,
    val admin_person_id: PersonId,
    val post_id: PostId,
    val reason: String? = null,
    val published: String,
) : DatatypeRoot
