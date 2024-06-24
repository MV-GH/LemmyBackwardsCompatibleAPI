package it.vercruysse.lemmyapi.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class ListCommentReportsResponse(
    val comment_reports: List<CommentReportView>,
)
