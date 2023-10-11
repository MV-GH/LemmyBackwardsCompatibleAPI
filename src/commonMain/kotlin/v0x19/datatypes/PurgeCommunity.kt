package v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class PurgeCommunity(
    val community_id: CommunityId,
    val reason: String? = null,
)
