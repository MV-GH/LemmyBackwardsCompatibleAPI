package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class LinkMetadata(
    val content_type: String? = null,
    val title: String? = null,
    val description: String? = null,
    val image: String? = null,
    val image_width: Long? = null,
    val image_height: Long? = null,
    val embed_video_url: String? = null,
    val video_width: Long? = null,
    val video_height: Long? = null,
) : DatatypeRoot
