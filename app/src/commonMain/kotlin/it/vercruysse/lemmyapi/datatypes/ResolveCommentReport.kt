package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@Serializable
data class ResolveCommentReport(
    val report_id: CommentReportId,
    val resolved: Boolean,
) : DatatypeRoot
