package it.vercruysse.lemmyapi.pictrs.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class UploadImage(
    val images: List<ByteArray>,
)
