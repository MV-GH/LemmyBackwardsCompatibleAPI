package it.vercruysse.lemmyapi.v0.x18.x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class PersonBlockView(
    val person: Person,
    val target: Person,
)
