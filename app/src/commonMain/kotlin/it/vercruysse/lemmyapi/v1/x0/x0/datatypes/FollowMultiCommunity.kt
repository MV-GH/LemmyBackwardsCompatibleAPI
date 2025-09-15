package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class FollowMultiCommunity(
    val multi_community_id: MultiCommunityId,
    val follow: Boolean,
)
