package v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class BlockCommunityResponse(
    val community_view: CommunityView,
    val blocked: Boolean,
)
