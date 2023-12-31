package it.vercruysse.lemmyapi.v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class AdminPurgePostView(
    val admin_purge_post: AdminPurgePost,
    val admin: Person? = null,
    val community: Community,
)
