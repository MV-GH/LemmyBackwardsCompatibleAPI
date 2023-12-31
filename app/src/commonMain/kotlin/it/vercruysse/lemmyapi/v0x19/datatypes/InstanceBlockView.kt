package it.vercruysse.lemmyapi.v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class InstanceBlockView(
    val person: Person,
    val instance: Instance,
    val site: Site? = null,
)
