package it.vercruysse.lemmyapi.v0.x18.x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class AdminPurgePostView(
    val admin_purge_post: AdminPurgePost,
    val admin: Person? = null,
    val community: Community,
)
