package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@Serializable
data class GetReportCount(
    val community_id: CommunityId? = null,
) : DatatypeRoot
