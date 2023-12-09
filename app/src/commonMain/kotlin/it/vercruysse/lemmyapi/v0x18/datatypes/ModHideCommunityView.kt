package it.vercruysse.lemmyapi.v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class ModHideCommunityView(
    val mod_hide_community: ModHideCommunity,
    val admin: Person? = null,
    val community: Community,
)
