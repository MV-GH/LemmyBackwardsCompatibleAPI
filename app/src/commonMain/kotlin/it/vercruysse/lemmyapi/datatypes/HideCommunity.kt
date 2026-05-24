package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class HideCommunity(
    val community_id: CommunityId,
    val hidden: Boolean,
    val reason: String,
) : DatatypeRoot
