package v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class ResolvePostReport(
    val report_id: PostReportId,
    val resolved: Boolean,
    val auth: String,
)
