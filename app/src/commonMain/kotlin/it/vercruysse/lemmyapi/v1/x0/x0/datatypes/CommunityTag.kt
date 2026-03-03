package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class CommunityTag(
    val id: CommunityTagId,
    val ap_id: DbUrl,
    val name: String,
    val display_name: String? = null,
    val summary: String? = null,
    val community_id: CommunityId,
    val published_at: String,
    val updated_at: String? = null,
    val deleted: Boolean,
    val color: String /* "color01" | "color02" | "color03" | "color04" | "color05" | "color06" | "color07" | "color08" | "color09" | "color10" */,
)
