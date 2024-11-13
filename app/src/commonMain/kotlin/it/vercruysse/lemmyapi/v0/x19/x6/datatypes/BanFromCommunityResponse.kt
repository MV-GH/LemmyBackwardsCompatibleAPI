package it.vercruysse.lemmyapi.v0.x19.x6.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class BanFromCommunityResponse(
    val person_view: PersonView,
    val banned: Boolean,
)
