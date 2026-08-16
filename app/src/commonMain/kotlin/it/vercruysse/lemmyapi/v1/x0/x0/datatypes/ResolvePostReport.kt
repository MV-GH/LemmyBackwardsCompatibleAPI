package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class ResolvePostReport(
    val report_id: PostReportId,
    val resolved: Boolean,
)
