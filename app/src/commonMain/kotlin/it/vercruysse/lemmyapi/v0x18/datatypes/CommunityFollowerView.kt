package it.vercruysse.lemmyapi.v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class CommunityFollowerView(
    val community: Community,
    val follower: Person,
)
