package it.vercruysse.lemmyapi.v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class ResolvePostReport(
    val report_id: PostReportId,
    val resolved: Boolean,
    val auth: String,
)
