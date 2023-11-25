package it.vercruysse.lemmyapi.v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class ModTransferCommunity(
    val id: Int,
    val mod_person_id: PersonId,
    val other_person_id: PersonId,
    val community_id: CommunityId,
    val when_: String,
)
