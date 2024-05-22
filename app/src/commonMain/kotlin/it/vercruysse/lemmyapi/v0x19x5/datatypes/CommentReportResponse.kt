package it.vercruysse.lemmyapi.v0x19x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class CommentReportResponse(
    val comment_report_view: CommentReportView,
)
