package it.vercruysse.lemmyapi.v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class ModRemoveCommunity(
    val id: Int,
    val mod_person_id: PersonId,
    val community_id: CommunityId,
    val reason: String? = null,
    val removed: Boolean,
    val when_: String,
)
