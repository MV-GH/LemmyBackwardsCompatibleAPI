package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@Serializable
data class BlockPersonResponse(
    val person_view: PersonView,
    val blocked: Boolean,
) : DatatypeRoot
