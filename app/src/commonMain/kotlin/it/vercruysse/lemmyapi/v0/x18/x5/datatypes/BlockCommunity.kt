package it.vercruysse.lemmyapi.v0.x18.x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class BlockCommunity(
    val community_id: CommunityId,
    val block: Boolean,
    val auth: String,
)
