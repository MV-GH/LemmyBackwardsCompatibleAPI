package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class CreateCommunityTag(
    val community_id: CommunityId,
    val name: String,
    val display_name: String? = null,
    val summary: String? = null,
    val color: String? /* "color01" | "color02" | "color03" | "color04" | "color05" | "color06" | "color07" | "color08" | "color09" | "color10" */ = null,
    ): DatatypeRoot
