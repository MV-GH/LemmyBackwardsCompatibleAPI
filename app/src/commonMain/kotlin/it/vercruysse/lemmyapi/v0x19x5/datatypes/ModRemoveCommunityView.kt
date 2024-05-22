package it.vercruysse.lemmyapi.v0x19x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class ModRemoveCommunityView(
    val mod_remove_community: ModRemoveCommunity,
    val moderator: Person? = null,
    val community: Community,
)
