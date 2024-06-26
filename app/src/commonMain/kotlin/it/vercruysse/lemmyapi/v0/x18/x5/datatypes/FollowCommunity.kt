package it.vercruysse.lemmyapi.v0.x18.x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class FollowCommunity(
    val community_id: CommunityId,
    val follow: Boolean,
    val auth: String,
)
