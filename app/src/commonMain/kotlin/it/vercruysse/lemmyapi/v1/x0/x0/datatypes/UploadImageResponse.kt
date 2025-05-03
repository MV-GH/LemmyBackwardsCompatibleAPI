package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class UploadImageResponse(
    val image_url: String,
    val filename: String,
)
