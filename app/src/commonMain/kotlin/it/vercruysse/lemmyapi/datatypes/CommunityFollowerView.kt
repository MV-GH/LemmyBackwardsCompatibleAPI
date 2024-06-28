package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@Serializable
data class CommunityFollowerView(
    val community: Community,
    val follower: Person,
) : DatatypeRoot
