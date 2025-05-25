package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
internal data class CreateCommunityTag(
    val community_id: CommunityId,
    val display_name: String,
): DatatypeRoot
