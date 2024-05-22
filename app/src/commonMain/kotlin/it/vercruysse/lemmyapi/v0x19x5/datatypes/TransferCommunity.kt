package it.vercruysse.lemmyapi.v0x19x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class TransferCommunity(
    val community_id: CommunityId,
    val person_id: PersonId,
)
