package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@Serializable
data class BlockCommunityResponse(
    val community_view: CommunityView,
    val blocked: Boolean,
) : DatatypeRoot
