package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@Serializable
data class ListMediaResponse(
    val images: List<LocalImageView>,
) : DatatypeRoot
