package it.vercruysse.lemmyapi.v0.x19.x11.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class CommentReportResponse(
    val comment_report_view: CommentReportView,
)
