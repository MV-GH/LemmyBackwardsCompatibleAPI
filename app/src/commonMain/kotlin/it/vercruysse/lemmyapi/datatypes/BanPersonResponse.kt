package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@Serializable
data class BanPersonResponse(
    val person_view: PersonView,
    val banned: Boolean,
) : DatatypeRoot
