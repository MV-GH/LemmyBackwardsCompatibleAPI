package it.vercruysse.lemmyapi.pictrs.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class UploadImageResponse(
    /**
     * "ok" if good includes files, else error message
     */
    val msg: String,
    val files: List<ImageFile> = listOf(),
)
