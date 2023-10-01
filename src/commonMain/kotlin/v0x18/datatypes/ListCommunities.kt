package v0x18.datatypes

import dto.ListingType
import dto.SortType
import kotlinx.serialization.Serializable

@Serializable
data class ListCommunities(
    val type_: ListingType? /* "All" | "Local" | "Subscribed" */ = null,
    val sort: SortType? /* "Active" | "Hot" | "New" | "Old" | "TopDay" | "TopWeek" | "TopMonth" | "TopYear" | "TopAll" | "MostComments" | "NewComments" | "TopHour" | "TopSixHour" | "TopTwelveHour" | "TopThreeMonths" | "TopSixMonths" | "TopNineMonths" */ = null,
    val show_nsfw: Boolean? = null,
    val page: Int? = null,
    val limit: Int? = null,
    val auth: String? = null,
)
