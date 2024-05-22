package it.vercruysse.lemmyapi.v0x19x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class RemoveCommunity(
    val community_id: CommunityId,
    val removed: Boolean,
    val reason: String? = null,
)
