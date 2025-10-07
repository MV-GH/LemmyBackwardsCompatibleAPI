package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class AdminRemoveCommunityView(
    val admin_remove_community: AdminRemoveCommunity,
    val moderator: Person? = null,
    val community: Community,
)
