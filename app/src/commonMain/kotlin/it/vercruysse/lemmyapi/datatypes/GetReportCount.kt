package it.vercruysse.lemmyapi.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class GetReportCount(
    val community_id: CommunityId? = null,
)
