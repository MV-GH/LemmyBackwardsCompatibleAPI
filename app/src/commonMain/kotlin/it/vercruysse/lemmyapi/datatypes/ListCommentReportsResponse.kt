package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@Serializable
data class ListCommentReportsResponse(
    val comment_reports: List<CommentReportView>,
) : DatatypeRoot
