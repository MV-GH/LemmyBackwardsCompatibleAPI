package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@Serializable
data class PersonBlockView(
    val person: Person,
    val target: Person,
) : DatatypeRoot
