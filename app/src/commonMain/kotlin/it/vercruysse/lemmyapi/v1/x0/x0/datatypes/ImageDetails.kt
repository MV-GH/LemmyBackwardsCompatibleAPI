package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class ImageDetails(
    val link: DbUrl,
    val width: Long,
    val height: Long,
    val content_type: String,
    val blurhash: String? = null,
)
