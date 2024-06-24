package it.vercruysse.lemmyapi.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class AddModToCommunityResponse(
    val moderators: List<CommunityModeratorView>,
)
