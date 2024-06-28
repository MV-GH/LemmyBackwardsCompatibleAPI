package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@Serializable
data class AddModToCommunity(
    val community_id: CommunityId,
    val person_id: PersonId,
    val added: Boolean,
) : DatatypeRoot
