package it.vercruysse.lemmyapi.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class ListMediaResponse(
    val images: List<LocalImageView>,
)
