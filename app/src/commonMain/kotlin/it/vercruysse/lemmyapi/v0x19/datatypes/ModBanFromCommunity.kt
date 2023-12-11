package it.vercruysse.lemmyapi.v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class ModBanFromCommunity(
    val id: Int,
    val mod_person_id: PersonId,
    val other_person_id: PersonId,
    val community_id: CommunityId,
    val reason: String? = null,
    val banned: Boolean,
    val expires: String? = null,
    val when_: String,
)
