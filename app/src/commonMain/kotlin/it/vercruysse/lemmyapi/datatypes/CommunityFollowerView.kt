package it.vercruysse.lemmyapi.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class CommunityFollowerView(
    val community: Community,
    val follower: Person,
)
