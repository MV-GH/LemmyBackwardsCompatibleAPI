package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class EditCommunityTag(
    val tag_id: CommunityTagId,
    val display_name: String? = null,
    val summary: String? = null,
    val color: String? /* "color01" | "color02" | "color03" | "color04" | "color05" | "color06" | "color07" | "color08" | "color09" | "color10" */ = null,
)
