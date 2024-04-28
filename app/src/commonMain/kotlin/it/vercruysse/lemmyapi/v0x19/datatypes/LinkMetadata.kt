package it.vercruysse.lemmyapi.v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class LinkMetadata(
    val title: String? = null,
    val description: String? = null,
    val image: String? = null,
    val embed_video_url: String? = null,
    val content_type: String? = null, // Added in 0.19.4
)
