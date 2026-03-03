package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import it.vercruysse.lemmyapi.dto.SortType
import it.vercruysse.lemmyapi.dto.ListingType
import kotlinx.serialization.Serializable

@Serializable
internal data class ListCommunities(
    val type_: ListingType? /* "all" | "local" | "subscribed" | "moderator_view" | "suggested" */ = null,
    val sort: SortType? /* "active_six_months" | "active_monthly" | "active_weekly" | "active_daily" | "hot" | "new" | "old" | "name_asc" | "name_desc" | "comments" | "posts" | "subscribers" | "subscribers_local" */ = null,
    val time_range_seconds: Long? = null,
    val show_nsfw: Boolean? = null,
    val page_cursor: PaginationCursor? = null,
    val limit: Long? = null,
)
