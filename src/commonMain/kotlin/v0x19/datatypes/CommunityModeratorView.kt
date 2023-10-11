package v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class CommunityModeratorView(
    val community: Community,
    val moderator: Person,
)
