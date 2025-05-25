package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.Identity
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

@CommonParcelize
@Serializable
data class AdminPurgePost(
    override val id: AdminPurgePostId,
    val admin_person_id: PersonId,
    val community_id: CommunityId,
    val reason: String? = null,
    val published: String,
) : DatatypeRoot, Identity
