package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

@CommonParcelize
@Serializable
data class AdminRemoveCommunity(
    val id: Long,
    val mod_person_id: PersonId,
    val community_id: CommunityId,
    val reason: String? = null,
    val removed: Boolean,
    val published_at: String,
) : DatatypeRoot
