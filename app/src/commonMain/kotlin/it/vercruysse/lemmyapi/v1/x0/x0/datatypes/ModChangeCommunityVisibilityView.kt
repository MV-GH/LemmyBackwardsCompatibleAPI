package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class ModChangeCommunityVisibilityView(
    val mod_change_community_visibility: ModChangeCommunityVisibility,
    val moderator: Person? = null,
    val community: Community,
)
