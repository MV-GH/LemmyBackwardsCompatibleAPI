package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import it.vercruysse.lemmyapi.dto.ListingType
import kotlinx.serialization.Serializable

@Serializable
internal data class ListReports(
    val unresolved_only: Boolean? = null,
    val type_: ListingType? /* "All" | "Posts" | "Comments" | "PrivateMessages" | "Communities" */ = null,
    val post_id: PostId? = null,
    val community_id: CommunityId? = null,
    val page_cursor: PaginationCursor? = null,
    val page_back: Boolean? = null,
    val limit: Long? = null,
    val show_community_rule_violations: Boolean? = null,
    val my_reports_only: Boolean? = null,
)
