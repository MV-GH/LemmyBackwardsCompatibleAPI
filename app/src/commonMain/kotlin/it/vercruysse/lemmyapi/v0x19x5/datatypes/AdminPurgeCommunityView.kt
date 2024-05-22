package it.vercruysse.lemmyapi.v0x19x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class AdminPurgeCommunityView(
    val admin_purge_community: AdminPurgeCommunity,
    val admin: Person? = null,
)
