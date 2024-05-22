package it.vercruysse.lemmyapi.v0x19x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class ResolvePostReport(
    val report_id: PostReportId,
    val resolved: Boolean,
)
