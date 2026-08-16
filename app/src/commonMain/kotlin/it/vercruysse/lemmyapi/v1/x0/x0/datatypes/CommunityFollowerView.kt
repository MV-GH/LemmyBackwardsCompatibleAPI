package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class CommunityFollowerView(
    val community: Community,
    val follower: Person,
)
