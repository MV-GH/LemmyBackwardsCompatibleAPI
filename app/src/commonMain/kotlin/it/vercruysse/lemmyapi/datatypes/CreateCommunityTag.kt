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
    val description: String? = null,
): DatatypeRoot
