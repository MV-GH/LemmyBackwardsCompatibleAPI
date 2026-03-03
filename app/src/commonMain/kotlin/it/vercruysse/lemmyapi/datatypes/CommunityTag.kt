package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class CommunityTag(
    val id: CommunityTagId,
    val ap_id: String,
    /** Added in 1.0.0 */
    val name: String,
    val display_name: String? = null,
    /** Added in 1.0.0  */
    val summary: String? = null,
    val community_id: CommunityId,
    val published_at: String,
    val updated_at: String? = null,
    val deleted: Boolean,
    val color: String /* "color01" | "color02" | "color03" | "color04" | "color05" | "color06" | "color07" | "color08" | "color09" | "color10" */,
): DatatypeRoot
