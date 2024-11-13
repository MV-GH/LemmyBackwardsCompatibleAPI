package it.vercruysse.lemmyapi.v0.x19.x6.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class CommunityModeratorView(
    val community: Community,
    val moderator: Person,
)
