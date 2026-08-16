package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class GetMultiCommunityResponse(
    val multi_community_view: MultiCommunityView,
    val communities: List<CommunityView>,
) : DatatypeRoot
