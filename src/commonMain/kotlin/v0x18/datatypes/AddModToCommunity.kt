package v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class AddModToCommunity(
    val community_id: CommunityId,
    val person_id: PersonId,
    val added: Boolean,
    val auth: String,
)
