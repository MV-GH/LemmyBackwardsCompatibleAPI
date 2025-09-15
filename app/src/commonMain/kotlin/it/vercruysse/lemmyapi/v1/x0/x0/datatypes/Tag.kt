package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class Tag(
    val id: TagId,
    val ap_id: DbUrl,
    val name: String,
    val display_name: String? = null,
    val description: String? = null,
    val community_id: CommunityId,
    val published_at: String,
    val updated_at: String? = null,
    val deleted: Boolean,
)
