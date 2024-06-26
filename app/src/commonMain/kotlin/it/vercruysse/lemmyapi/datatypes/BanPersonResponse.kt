package it.vercruysse.lemmyapi.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class BanPersonResponse(
    val person_view: PersonView,
    val banned: Boolean,
)