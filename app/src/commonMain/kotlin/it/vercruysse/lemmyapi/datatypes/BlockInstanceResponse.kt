package it.vercruysse.lemmyapi.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class BlockInstanceResponse(
    val blocked: Boolean,
)
