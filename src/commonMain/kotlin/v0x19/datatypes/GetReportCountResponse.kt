package v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class GetReportCountResponse(
    val community_id: CommunityId? = null,
    val comment_reports: Int,
    val post_reports: Int,
    val private_message_reports: Int? = null,
)
