package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class CreateOrDeleteMultiCommunityEntry(
    val id: MultiCommunityId,
    val community_id: CommunityId,
) : DatatypeRoot
