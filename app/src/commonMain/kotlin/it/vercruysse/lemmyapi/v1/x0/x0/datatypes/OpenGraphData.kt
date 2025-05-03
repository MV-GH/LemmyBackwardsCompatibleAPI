package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class OpenGraphData(
    val title: String? = null,
    val description: String? = null,
    val image: DbUrl? = null,
    val embed_video_url: DbUrl? = null,
)
