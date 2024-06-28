package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@Serializable
data class FollowCommunity(
    val community_id: CommunityId,
    val follow: Boolean,
) : DatatypeRoot
