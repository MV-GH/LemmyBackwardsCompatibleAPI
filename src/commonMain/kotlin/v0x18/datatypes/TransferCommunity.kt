package v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class TransferCommunity(
    val community_id: CommunityId,
    val person_id: PersonId,
    val auth: String,
)
