package it.vercruysse.lemmyapi.v0x19.datatypes

import it.vercruysse.lemmyapi.dto.SortType
import it.vercruysse.lemmyapi.dto.ListingType
import kotlinx.serialization.Serializable

@Serializable
data class GetPosts(
    val type_: ListingType? /* "All" | "Local" | "Subscribed" | "ModeratorView" */ = null,
    val sort: SortType? /* "Active" | "Hot" | "New" | "Old" | "TopDay" | "TopWeek" | "TopMonth" | "TopYear" | "TopAll" | "MostComments" | "NewComments" | "TopHour" | "TopSixHour" | "TopTwelveHour" | "TopThreeMonths" | "TopSixMonths" | "TopNineMonths" | "Controversial" | "Scaled" */ = null,
    val page: Long? = null,
    val limit: Long? = null,
    val community_id: CommunityId? = null,
    val community_name: String? = null,
    val saved_only: Boolean? = null,
    val liked_only: Boolean? = null,
    val disliked_only: Boolean? = null,
    val page_cursor: PaginationCursor? = null,
)
