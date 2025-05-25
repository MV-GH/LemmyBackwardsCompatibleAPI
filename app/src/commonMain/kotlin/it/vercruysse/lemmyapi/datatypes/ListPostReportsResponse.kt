package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

// TODO: removed

@CommonParcelize
@Serializable
data class ListPostReportsResponse(
    val post_reports: List<PostReportView>,
) : DatatypeRoot
