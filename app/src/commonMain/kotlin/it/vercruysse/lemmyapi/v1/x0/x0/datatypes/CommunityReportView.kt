package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class CommunityReportView(
    val community_report: CommunityReport,
    val community: Community,
    val creator: Person,
    val resolver: Person? = null,
)
