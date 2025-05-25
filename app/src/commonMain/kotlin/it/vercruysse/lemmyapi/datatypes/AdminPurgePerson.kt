package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.Identity
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

@CommonParcelize
@Serializable
data class AdminPurgePerson(
    override val id: AdminPurgePersonId,
    val admin_person_id: PersonId,
    val reason: String? = null,
    val published: String,
) : DatatypeRoot, Identity
