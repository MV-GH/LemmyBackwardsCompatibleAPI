package it.vercruysse.lemmyapi.v0x18.datatypes

import it.vercruysse.lemmyapi.dto.ListingType
import it.vercruysse.lemmyapi.dto.SortType
import kotlinx.serialization.Serializable

@Serializable
internal data class GetPosts(
    val type_: ListingType? /* "All" | "Local" | "Subscribed" */ = null,
    val sort: SortType? /* "Active" | "Hot" | "New" | "Old" | "TopDay" | "TopWeek" | "TopMonth" | "TopYear" | "TopAll" | "MostComments" | "NewComments" | "TopHour" | "TopSixHour" | "TopTwelveHour" | "TopThreeMonths" | "TopSixMonths" | "TopNineMonths" */ = null,
    val page: Int? = null,
    val limit: Int? = null,
    val community_id: CommunityId? = null,
    val community_name: String? = null,
    val saved_only: Boolean? = null,
    val auth: String? = null,
)
