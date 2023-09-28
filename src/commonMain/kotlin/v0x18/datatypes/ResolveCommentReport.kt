package v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class ResolveCommentReport(
    val report_id: CommentReportId,
    val resolved: Boolean,
    val auth: String,
)
