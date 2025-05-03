package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import it.vercruysse.lemmyapi.dto.SortType
import it.vercruysse.lemmyapi.dto.ListingType
import kotlinx.serialization.Serializable

@Serializable
internal data class ListCommunities(
    val type_: ListingType? /* "All" | "Local" | "Subscribed" | "ModeratorView" */ = null,
    val sort: SortType? /* "ActiveSixMonths" | "ActiveMonthly" | "ActiveWeekly" | "ActiveDaily" | "Hot" | "New" | "Old" | "NameAsc" | "NameDesc" | "Comments" | "Posts" | "Subscribers" | "SubscribersLocal" */ = null,
    val time_range_seconds: Long? = null,
    val show_nsfw: Boolean? = null,
    val page_cursor: PaginationCursor? = null,
    val page_back: Boolean? = null,
    val limit: Long? = null,
)
