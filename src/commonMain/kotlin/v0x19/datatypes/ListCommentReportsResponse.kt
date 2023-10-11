package v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class ListCommentReportsResponse(
    val comment_reports: List<CommentReportView>,
)
