package it.vercruysse.lemmyapi.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class GetSiteMetadataResponse(
    val metadata: LinkMetadata,
)
