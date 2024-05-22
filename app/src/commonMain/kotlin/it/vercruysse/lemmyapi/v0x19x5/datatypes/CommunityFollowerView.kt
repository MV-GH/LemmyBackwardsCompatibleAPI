package it.vercruysse.lemmyapi.v0x19x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class CommunityFollowerView(
    val community: Community,
    val follower: Person,
)
