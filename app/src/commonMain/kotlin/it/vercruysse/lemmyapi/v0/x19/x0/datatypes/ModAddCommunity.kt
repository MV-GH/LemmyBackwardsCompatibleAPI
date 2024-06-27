package it.vercruysse.lemmyapi.v0.x19.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class ModAddCommunity(
    val id: Long,
    val mod_person_id: PersonId,
    val other_person_id: PersonId,
    val community_id: CommunityId,
    val removed: Boolean,
    val when_: String,
)
