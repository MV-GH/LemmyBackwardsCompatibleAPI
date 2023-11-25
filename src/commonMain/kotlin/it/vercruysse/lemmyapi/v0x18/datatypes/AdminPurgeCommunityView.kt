package it.vercruysse.lemmyapi.v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class AdminPurgeCommunityView(
    val admin_purge_community: AdminPurgeCommunity,
    val admin: Person? = null,
)
