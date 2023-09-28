package v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class HideCommunity(
    val community_id: CommunityId,
    val hidden: Boolean,
    val reason: String? = null,
    val auth: String,
)
