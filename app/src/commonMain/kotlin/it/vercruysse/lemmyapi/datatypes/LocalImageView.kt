package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@Serializable
data class LocalImageView(
    val local_image: LocalImage,
    val person: Person,
) : DatatypeRoot
