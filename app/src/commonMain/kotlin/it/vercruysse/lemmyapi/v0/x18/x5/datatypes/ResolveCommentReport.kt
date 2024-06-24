package it.vercruysse.lemmyapi.v0.x18.x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class ResolveCommentReport(
    val report_id: CommentReportId,
    val resolved: Boolean,
    val auth: String,
)
