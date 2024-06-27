package it.vercruysse.lemmyapi.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class CommentReportResponse(
    val comment_report_view: CommentReportView,
)
