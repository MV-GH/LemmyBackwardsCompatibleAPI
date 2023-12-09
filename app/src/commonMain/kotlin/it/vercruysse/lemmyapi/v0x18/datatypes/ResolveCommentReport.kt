package it.vercruysse.lemmyapi.v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class ResolveCommentReport(
    val report_id: CommentReportId,
    val resolved: Boolean,
    val auth: String,
)
