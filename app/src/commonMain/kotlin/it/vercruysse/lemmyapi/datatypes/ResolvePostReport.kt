package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

@CommonParcelize
@Serializable
data class ResolvePostReport(
    val report_id: PostReportId,
    val resolved: Boolean,
) : DatatypeRoot
