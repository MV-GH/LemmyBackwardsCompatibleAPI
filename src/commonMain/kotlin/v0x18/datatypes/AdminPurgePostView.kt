package v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class AdminPurgePostView(
    val admin_purge_post: AdminPurgePost,
    val admin: Person? = null,
    val community: Community,
)
