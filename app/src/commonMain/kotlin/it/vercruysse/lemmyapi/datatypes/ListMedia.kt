package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@Serializable
data class ListMedia(
    val page: Long? = null,
    val limit: Long? = null,
) : DatatypeRoot
