package v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class ResolveCommentReport(
    val report_id: CommentReportId,
    val resolved: Boolean,
)
