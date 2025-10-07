package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class ModAddToCommunityView(
    val mod_add_to_community: ModAddToCommunity,
    val moderator: Person? = null,
    val community: Community,
    val other_person: Person,
)
