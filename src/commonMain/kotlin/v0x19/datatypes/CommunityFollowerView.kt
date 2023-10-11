package v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class CommunityFollowerView(
    val community: Community,
    val follower: Person,
)
