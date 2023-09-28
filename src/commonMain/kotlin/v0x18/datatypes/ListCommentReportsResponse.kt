package v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class ListCommentReportsResponse(
    val comment_reports: List<CommentReportView>,
)
