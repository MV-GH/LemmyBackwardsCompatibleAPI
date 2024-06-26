package it.vercruysse.lemmyapi.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class ModBanFromCommunityView(
    val mod_ban_from_community: ModBanFromCommunity,
    val moderator: Person? = null,
    val community: Community,
    val banned_person: Person,
)