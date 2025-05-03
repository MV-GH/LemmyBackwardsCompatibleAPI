package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class Tag(
    val id: TagId,
    val ap_id: DbUrl,
    val display_name: String,
    val community_id: CommunityId,
    val published: String,
    val updated: String? = null,
    val deleted: Boolean,
)
