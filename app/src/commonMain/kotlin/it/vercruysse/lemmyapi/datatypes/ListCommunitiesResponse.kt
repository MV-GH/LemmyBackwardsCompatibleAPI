package it.vercruysse.lemmyapi.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class ListCommunitiesResponse(
    val communities: List<CommunityView>,
)
