package it.vercruysse.lemmyapi.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class BannedPersonsResponse(
    val banned: List<PersonView>,
)
