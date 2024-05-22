package it.vercruysse.lemmyapi.v0x19x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class BlockCommunity(
    val community_id: CommunityId,
    val block: Boolean,
)
