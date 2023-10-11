package v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class CommunityBlockView(
    val person: Person,
    val community: Community,
)
