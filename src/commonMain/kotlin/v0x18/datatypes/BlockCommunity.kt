package v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class BlockCommunity(
    val community_id: CommunityId,
    val block: Boolean,
    val auth: String,
)
