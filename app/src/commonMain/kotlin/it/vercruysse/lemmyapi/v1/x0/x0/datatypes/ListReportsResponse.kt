package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class ListReportsResponse(
    val reports: List<dynamic /* `T$199` & PostReportView | `T$200` & CommentReportView | `T$23` & PrivateMessageReportView | `T$201` & CommunityReportView */>,
    val next_page: PaginationCursor? = null,
    val prev_page: PaginationCursor? = null,
)
