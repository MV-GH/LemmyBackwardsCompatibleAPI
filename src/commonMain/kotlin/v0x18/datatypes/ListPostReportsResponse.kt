package v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class ListPostReportsResponse(
    val post_reports: List<PostReportView>,
)
