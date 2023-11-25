package it.vercruysse.lemmyapi.v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class ModAddCommunityView(
    val mod_add_community: ModAddCommunity,
    val moderator: Person? = null,
    val community: Community,
    val modded_person: Person,
)
