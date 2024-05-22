package it.vercruysse.lemmyapi.v0x19x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class ResolveCommentReport(
    val report_id: CommentReportId,
    val resolved: Boolean,
)
