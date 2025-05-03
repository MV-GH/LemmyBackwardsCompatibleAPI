package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class HideCommunity(
    val community_id: CommunityId,
    val hidden: Boolean,
    val reason: String? = null,
)
