package it.vercruysse.lemmyapi.v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class GetReportCountResponse(
    val community_id: CommunityId? = null,
    val comment_reports: Long,
    val post_reports: Long,
    val private_message_reports: Long? = null,
)
