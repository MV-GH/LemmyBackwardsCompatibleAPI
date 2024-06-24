package it.vercruysse.lemmyapi.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class ResolvePostReport(
    val report_id: PostReportId,
    val resolved: Boolean,
)
