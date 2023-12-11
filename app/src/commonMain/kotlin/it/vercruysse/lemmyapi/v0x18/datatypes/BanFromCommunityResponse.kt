package it.vercruysse.lemmyapi.v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class BanFromCommunityResponse(
    val person_view: PersonView,
    val banned: Boolean,
)
