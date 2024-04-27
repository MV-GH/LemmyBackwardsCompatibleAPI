package it.vercruysse.lemmyapi.v0x19.datatypes

import kotlinx.serialization.Serializable

// Added in 0.19.4
@Serializable
data class ListMediaResponse(
    val images: List<LocalImage>,
)
