package it.vercruysse.lemmyapi.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class LocalImageView(
    val local_image: LocalImage,
    val person: Person,
)
