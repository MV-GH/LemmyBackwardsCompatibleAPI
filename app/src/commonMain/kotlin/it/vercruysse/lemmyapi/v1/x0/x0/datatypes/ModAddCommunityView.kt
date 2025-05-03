package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class ModAddCommunityView(
    val mod_add_community: ModAddCommunity,
    val moderator: Person? = null,
    val community: Community,
    val other_person: Person,
)
