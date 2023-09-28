package v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class CommunityJoin(
    val community_id: CommunityId,
)
