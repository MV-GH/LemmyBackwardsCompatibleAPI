package v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class ModJoin(
    val community_id: CommunityId,
)
