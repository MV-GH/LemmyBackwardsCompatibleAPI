package it.vercruysse.lemmyapi.v0.x19.x6.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class ResolvePostReport(
    val report_id: PostReportId,
    val resolved: Boolean,
)
