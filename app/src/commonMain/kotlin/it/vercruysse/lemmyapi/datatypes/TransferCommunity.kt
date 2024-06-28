package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@Serializable
data class TransferCommunity(
    val community_id: CommunityId,
    val person_id: PersonId,
) : DatatypeRoot
