package it.vercruysse.lemmyapi.v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class PurgeCommunity(
    val community_id: CommunityId,
    val reason: String? = null,
    val auth: String,
)
