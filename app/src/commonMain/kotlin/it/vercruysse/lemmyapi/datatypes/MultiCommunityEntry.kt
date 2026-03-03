package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class MultiCommunityEntry(
    val multi_community_id: MultiCommunityId,
    val community_id: CommunityId,
) : DatatypeRoot
