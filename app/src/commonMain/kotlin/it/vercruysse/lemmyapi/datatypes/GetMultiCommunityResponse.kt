package it.vercruysse.lemmyapi.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class GetMultiCommunityResponse(
    val multi_community_view: MultiCommunityView,
    val communities: List<CommunityView>,
)
