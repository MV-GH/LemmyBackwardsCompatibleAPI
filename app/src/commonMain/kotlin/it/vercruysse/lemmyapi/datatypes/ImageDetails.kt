package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class ImageDetails(
    val link: String,
    val width: Long,
    val height: Long,
    val content_type: String,
) : DatatypeRoot
