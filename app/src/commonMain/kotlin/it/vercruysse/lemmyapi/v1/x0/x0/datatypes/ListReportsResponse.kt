package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import it.vercruysse.lemmyapi.v1.x0.x0.combinedtypes.ReportCombinedView
import kotlinx.serialization.Serializable

// TODO: changed in new

@Serializable
internal data class ListReportsResponse(
    val reports: List<ReportCombinedView>,
    val next_page: PaginationCursor? = null,
    val prev_page: PaginationCursor? = null,
)
