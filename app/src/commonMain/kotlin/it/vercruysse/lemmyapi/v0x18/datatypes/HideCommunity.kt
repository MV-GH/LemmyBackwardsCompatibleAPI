package it.vercruysse.lemmyapi.v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class HideCommunity(
    val community_id: CommunityId,
    val hidden: Boolean,
    val reason: String? = null,
    val auth: String,
)
