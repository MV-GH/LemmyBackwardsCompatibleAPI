package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@Serializable
data class DeleteCommunity(
    val community_id: CommunityId,
    val deleted: Boolean,
) : DatatypeRoot
