package it.vercruysse.lemmyapi.v0x19x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class ModHideCommunityView(
    val mod_hide_community: ModHideCommunity,
    val admin: Person? = null,
    val community: Community,
)
