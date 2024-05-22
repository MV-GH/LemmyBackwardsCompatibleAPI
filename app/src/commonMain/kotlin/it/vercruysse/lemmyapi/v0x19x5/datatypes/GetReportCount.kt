package it.vercruysse.lemmyapi.v0x19x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class GetReportCount(
    val community_id: CommunityId? = null,
)
