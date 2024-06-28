package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@Serializable
data class GetSiteMetadataResponse(
    val metadata: LinkMetadata,
) : DatatypeRoot
