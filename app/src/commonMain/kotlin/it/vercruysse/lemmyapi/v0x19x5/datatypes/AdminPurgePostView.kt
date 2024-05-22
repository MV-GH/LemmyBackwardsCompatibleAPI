package it.vercruysse.lemmyapi.v0x19x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class AdminPurgePostView(
    val admin_purge_post: AdminPurgePost,
    val admin: Person? = null,
    val community: Community,
)
