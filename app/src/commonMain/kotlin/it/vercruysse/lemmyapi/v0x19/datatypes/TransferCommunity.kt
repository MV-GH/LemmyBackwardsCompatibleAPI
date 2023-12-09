package it.vercruysse.lemmyapi.v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class TransferCommunity(
    val community_id: CommunityId,
    val person_id: PersonId,
)
