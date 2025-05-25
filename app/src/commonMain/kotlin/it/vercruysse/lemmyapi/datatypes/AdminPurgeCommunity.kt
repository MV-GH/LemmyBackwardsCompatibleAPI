package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.Identity
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

@CommonParcelize
@Serializable
data class AdminPurgeCommunity(
    override val id: AdminPurgeCommunityId,
    val admin_person_id: PersonId,
    val reason: String? = null,
    val published: String,
) : DatatypeRoot, Identity
