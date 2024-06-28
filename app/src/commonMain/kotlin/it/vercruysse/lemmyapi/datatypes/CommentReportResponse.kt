package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@Serializable
data class CommentReportResponse(
    val comment_report_view: CommentReportView,
) : DatatypeRoot
