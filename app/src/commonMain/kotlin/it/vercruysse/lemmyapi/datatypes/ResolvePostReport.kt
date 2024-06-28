package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@Serializable
data class ResolvePostReport(
    val report_id: PostReportId,
    val resolved: Boolean,
) : DatatypeRoot
