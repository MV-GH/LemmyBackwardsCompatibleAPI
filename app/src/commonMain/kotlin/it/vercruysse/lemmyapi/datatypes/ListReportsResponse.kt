package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class ListReportsResponse(
    val reports: List<ReportCombinedView>,
    val next_page: PaginationCursor? = null,
    val prev_page: PaginationCursor? = null,
): DatatypeRoot
