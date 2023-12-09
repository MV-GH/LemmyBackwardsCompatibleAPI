package it.vercruysse.lemmyapi.v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class BlockInstanceResponse(
    val blocked: Boolean,
)
