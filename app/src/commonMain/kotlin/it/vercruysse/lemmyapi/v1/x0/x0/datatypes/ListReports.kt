package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import it.vercruysse.lemmyapi.enums.ReportSortType
import it.vercruysse.lemmyapi.enums.ReportType
import kotlinx.serialization.Serializable

@Serializable
internal data class ListReports(
    val unresolved_only: Boolean? = null,
    val type_: ReportType? /* "all" | "posts" | "comments" | "private_messages" | "communities" */ = null,
    val post_id: PostId? = null,
    val community_id: CommunityId? = null,
    val sort: ReportSortType? /* "default" | "new" | "old" */ = null,
    val page_cursor: PaginationCursor? = null,
    val limit: Long? = null,
    val show_community_rule_violations: Boolean? = null,
    val my_reports_only: Boolean? = null,
)
