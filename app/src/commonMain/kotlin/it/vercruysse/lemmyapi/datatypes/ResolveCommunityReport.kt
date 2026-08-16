package it.vercruysse.lemmyapi.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class ResolveCommunityReport(
    val report_id: CommunityReportId,
    val resolved: Boolean,
)
