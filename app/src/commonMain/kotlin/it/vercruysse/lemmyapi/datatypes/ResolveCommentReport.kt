package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class ResolveCommentReport(
    val report_id: CommentReportId,
    val resolved: Boolean,
) : DatatypeRoot
