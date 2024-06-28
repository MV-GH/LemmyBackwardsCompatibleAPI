package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@Serializable
data class BannedPersonsResponse(
    val banned: List<PersonView>,
) : DatatypeRoot
