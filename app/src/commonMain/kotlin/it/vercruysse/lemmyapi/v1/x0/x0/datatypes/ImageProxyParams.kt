package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class ImageProxyParams(
    val url: String,
    val file_type: String? = null,
    val max_size: Long? = null,
)
