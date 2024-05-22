package it.vercruysse.lemmyapi.v0x19x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class OpenGraphData(
    val title: String? = null,
    val description: String? = null,
    val image: String? = null,
    val embed_video_url: String? = null,
)
