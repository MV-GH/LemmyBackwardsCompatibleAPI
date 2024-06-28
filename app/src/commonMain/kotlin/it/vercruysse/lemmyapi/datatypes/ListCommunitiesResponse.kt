package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@Serializable
data class ListCommunitiesResponse(
    val communities: List<CommunityView>,
) : DatatypeRoot
