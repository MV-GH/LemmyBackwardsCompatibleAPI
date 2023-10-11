package v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class SiteMetadata(
    val title: String? = null,
    val description: String? = null,
    val image: String? = null,
    val embed_video_url: String? = null,
)
