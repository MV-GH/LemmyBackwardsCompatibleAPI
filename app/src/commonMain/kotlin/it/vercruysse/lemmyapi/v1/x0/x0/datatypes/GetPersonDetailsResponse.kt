package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class GetPersonDetailsResponse(
    val person_view: PersonView,
    val site: Site? = null,
    val moderates: List<CommunityModeratorView>,
)
