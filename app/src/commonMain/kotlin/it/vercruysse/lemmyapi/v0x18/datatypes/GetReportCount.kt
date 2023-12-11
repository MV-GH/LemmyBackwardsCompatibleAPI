package it.vercruysse.lemmyapi.v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class GetReportCount(
    val community_id: CommunityId? = null,
    val auth: String,
)
