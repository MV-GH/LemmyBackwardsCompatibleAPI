package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@Serializable
data class PurgeCommunity(
    val community_id: CommunityId,
    val reason: String? = null,
) : DatatypeRoot
