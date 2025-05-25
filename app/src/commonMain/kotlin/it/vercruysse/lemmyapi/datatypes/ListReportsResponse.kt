package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

// TODO: dynamic

@CommonParcelize
@Serializable
data class ListReportsResponse(
    val reports: List<dynamic /* `T$199` & PostReportView | `T$200` & CommentReportView | `T$23` & PrivateMessageReportView | `T$201` & CommunityReportView */>,
    val next_page: PaginationCursor? = null,
    val prev_page: PaginationCursor? = null,
): DatatypeRoot
