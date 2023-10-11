package v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class FollowCommunity(
    val community_id: CommunityId,
    val follow: Boolean,
)
