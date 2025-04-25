package it.vercruysse.lemmyapi.v0.x19.x11.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class ImageDetails(
    val link: String,
    val width: Long,
    val height: Long,
    val content_type: String,
)
