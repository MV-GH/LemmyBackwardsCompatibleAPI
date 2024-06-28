package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@Serializable
data class BlockCommunity(
    val community_id: CommunityId,
    val block: Boolean,
) : DatatypeRoot
