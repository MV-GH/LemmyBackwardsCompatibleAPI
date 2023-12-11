package it.vercruysse.lemmyapi.v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class CommentReportResponse(
    val comment_report_view: CommentReportView,
)
