package it.vercruysse.lemmyapi.v0x19x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class ModHideCommunity(
    val id: Long,
    val community_id: CommunityId,
    val mod_person_id: PersonId,
    val when_: String,
    val reason: String? = null,
    val hidden: Boolean,
)
