package it.vercruysse.lemmyapi.v0.x19.x6.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class BlockCommunity(
    val community_id: CommunityId,
    val block: Boolean,
)
