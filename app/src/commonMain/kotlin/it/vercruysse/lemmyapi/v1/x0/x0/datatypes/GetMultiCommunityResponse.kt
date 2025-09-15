package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class GetMultiCommunityResponse(
    val multi_community_view: MultiCommunityView,
    val communities: List<CommunityView>,
)
