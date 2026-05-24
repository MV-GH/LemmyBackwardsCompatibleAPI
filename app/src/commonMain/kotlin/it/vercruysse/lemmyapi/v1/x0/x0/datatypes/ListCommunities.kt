package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import it.vercruysse.lemmyapi.enums.ListingType
import it.vercruysse.lemmyapi.enums.SortType
import kotlinx.serialization.Serializable

@Serializable
internal data class ListCommunities(
    val type_: ListingType? /* "all" | "local" | "subscribed" | "moderator_view" | "suggested" */ = null,
    val sort: SortType? /* "active_six_months" | "active_monthly" | "active_weekly" | "active_daily" | "hot" | "new" | "old" | "name_asc" | "name_desc" | "comments" | "posts" | "subscribers" | "subscribers_local" */ = null,
    val time_range_seconds: Long? = null,
    val show_nsfw: Boolean? = null,
    val multi_community_id: MultiCommunityId? = null,
    val search_term: String? = null,
    val search_title_only: Boolean? = null,
    val page_cursor: PaginationCursor? = null,
    val limit: Long? = null,
)
