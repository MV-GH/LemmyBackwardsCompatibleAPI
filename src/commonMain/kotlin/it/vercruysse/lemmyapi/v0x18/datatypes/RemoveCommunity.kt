package it.vercruysse.lemmyapi.v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class RemoveCommunity(
    val community_id: CommunityId,
    val removed: Boolean,
    val reason: String? = null,
    val expires: Int? = null,
    val auth: String,
)
