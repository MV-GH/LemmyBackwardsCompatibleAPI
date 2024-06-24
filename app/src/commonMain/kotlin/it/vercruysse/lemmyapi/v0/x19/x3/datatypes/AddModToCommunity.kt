package it.vercruysse.lemmyapi.v0.x19.x3.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class AddModToCommunity(
    val community_id: CommunityId,
    val person_id: PersonId,
    val added: Boolean,
)
