package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@Serializable
data class CommunityModeratorView(
    val community: Community,
    val moderator: Person,
) : DatatypeRoot
