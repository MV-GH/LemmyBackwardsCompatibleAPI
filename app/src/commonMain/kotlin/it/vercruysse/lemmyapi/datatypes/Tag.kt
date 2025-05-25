package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class Tag(
    val id: TagId,
    val ap_id: String,
    val display_name: String,
    val community_id: CommunityId,
    val published: String,
    val updated: String? = null,
    val deleted: Boolean,
): DatatypeRoot
