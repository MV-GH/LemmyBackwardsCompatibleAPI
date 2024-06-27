package it.vercruysse.lemmyapi.v0.x19.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class TransferCommunity(
    val community_id: CommunityId,
    val person_id: PersonId,
)
