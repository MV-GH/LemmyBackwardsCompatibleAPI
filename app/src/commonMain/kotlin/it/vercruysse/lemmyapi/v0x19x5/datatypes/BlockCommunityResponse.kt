package it.vercruysse.lemmyapi.v0x19x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class BlockCommunityResponse(
    val community_view: CommunityView,
    val blocked: Boolean,
)
