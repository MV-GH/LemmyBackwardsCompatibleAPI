package it.vercruysse.lemmyapi.v0x19x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class ModBanFromCommunity(
    val id: Long,
    val mod_person_id: PersonId,
    val other_person_id: PersonId,
    val community_id: CommunityId,
    val reason: String? = null,
    val banned: Boolean,
    val expires: String? = null,
    val when_: String,
)
