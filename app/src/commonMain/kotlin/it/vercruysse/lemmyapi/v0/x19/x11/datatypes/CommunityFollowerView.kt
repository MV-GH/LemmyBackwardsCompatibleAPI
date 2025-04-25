package it.vercruysse.lemmyapi.v0.x19.x11.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class CommunityFollowerView(
    val community: Community,
    val follower: Person,
)
