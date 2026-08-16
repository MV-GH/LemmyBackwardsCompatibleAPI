package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class RemoveCommunity(
    val community_id: CommunityId,
    val removed: Boolean,
    val reason: String,
) : DatatypeRoot
