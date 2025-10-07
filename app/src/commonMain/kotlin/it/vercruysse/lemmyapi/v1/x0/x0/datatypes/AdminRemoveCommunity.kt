package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class AdminRemoveCommunity(
    val id: AdminRemoveCommunityId,
    val mod_person_id: PersonId,
    val community_id: CommunityId,
    val reason: String,
    val removed: Boolean,
    val published_at: String,
)
