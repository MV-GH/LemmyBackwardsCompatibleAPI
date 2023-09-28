package v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class GetReportCount(
    val community_id: CommunityId? = null,
    val auth: String,
)
