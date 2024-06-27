package it.vercruysse.lemmyapi.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class CommunityModeratorView(
    val community: Community,
    val moderator: Person,
)
