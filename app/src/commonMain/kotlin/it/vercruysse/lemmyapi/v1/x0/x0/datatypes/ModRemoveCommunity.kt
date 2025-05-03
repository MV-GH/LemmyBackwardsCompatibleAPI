package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class ModRemoveCommunity(
    val id: ModRemoveCommunityId,
    val mod_person_id: PersonId,
    val community_id: CommunityId,
    val reason: String? = null,
    val removed: Boolean,
    val published: String,
)
