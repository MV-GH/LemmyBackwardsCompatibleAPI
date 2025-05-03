package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class AdminPurgePostView(
    val admin_purge_post: AdminPurgePost,
    val admin: Person? = null,
    val community: Community,
)
