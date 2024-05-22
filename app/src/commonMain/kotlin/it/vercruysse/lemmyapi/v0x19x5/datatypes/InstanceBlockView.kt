package it.vercruysse.lemmyapi.v0x19x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class InstanceBlockView(
    val person: Person,
    val instance: Instance,
    val site: Site? = null,
)
