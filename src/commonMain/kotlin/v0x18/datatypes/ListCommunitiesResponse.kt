package v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class ListCommunitiesResponse(
    val communities: List<CommunityView>,
)
