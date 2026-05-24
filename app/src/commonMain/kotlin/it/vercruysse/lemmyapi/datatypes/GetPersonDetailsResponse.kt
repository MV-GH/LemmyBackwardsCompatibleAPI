package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class GetPersonDetailsResponse(
    val person_view: PersonView,
    val site: Site? = null,
    val moderates: List<CommunityModeratorView>,
    val multi_communities_created: List<MultiCommunityView>,
) : DatatypeRoot
