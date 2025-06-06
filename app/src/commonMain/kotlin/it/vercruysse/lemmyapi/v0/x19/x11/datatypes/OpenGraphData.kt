package it.vercruysse.lemmyapi.v0.x19.x11.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class OpenGraphData(
    val title: String? = null,
    val description: String? = null,
    val image: String? = null,
    val embed_video_url: String? = null,
)
