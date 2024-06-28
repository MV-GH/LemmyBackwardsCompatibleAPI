package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

@CommonParcelize
@Serializable
data class PurgeCommunity(
    val community_id: CommunityId,
    val reason: String? = null,
) : DatatypeRoot
