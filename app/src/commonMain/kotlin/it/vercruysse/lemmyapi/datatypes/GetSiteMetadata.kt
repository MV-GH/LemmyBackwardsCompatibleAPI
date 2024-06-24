package it.vercruysse.lemmyapi.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class GetSiteMetadata(
    val url: String,
)
