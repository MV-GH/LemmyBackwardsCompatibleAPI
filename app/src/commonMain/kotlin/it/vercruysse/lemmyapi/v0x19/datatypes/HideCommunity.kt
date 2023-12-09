package it.vercruysse.lemmyapi.v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class HideCommunity(
    val community_id: CommunityId,
    val hidden: Boolean,
    val reason: String? = null,
)
