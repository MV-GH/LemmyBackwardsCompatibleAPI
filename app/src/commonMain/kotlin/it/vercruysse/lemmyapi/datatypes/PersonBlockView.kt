package it.vercruysse.lemmyapi.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class PersonBlockView(
    val person: Person,
    val target: Person,
)
