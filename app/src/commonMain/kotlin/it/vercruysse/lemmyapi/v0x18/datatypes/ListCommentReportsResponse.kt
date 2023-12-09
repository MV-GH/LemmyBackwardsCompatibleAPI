package it.vercruysse.lemmyapi.v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class ListCommentReportsResponse(
    val comment_reports: List<CommentReportView>,
)
