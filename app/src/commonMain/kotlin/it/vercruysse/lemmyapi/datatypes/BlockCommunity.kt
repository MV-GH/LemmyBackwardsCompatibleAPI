package it.vercruysse.lemmyapi.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class BlockCommunity(
    val community_id: CommunityId,
    val block: Boolean,
)
