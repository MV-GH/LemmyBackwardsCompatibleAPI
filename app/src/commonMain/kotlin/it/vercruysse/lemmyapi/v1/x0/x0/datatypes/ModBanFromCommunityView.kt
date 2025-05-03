package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class ModBanFromCommunityView(
    val mod_ban_from_community: ModBanFromCommunity,
    val moderator: Person? = null,
    val community: Community,
    val other_person: Person,
)
