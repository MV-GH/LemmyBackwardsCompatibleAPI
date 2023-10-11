package v0x19.datatypes

import dto.SortType
import dto.ListingType
import kotlinx.serialization.Serializable

@Serializable
data class ListCommunities(
    val type_: ListingType? /* "All" | "Local" | "Subscribed" | "ModeratorView" */ = null,
    val sort: SortType? /* "Active" | "Hot" | "New" | "Old" | "TopDay" | "TopWeek" | "TopMonth" | "TopYear" | "TopAll" | "MostComments" | "NewComments" | "TopHour" | "TopSixHour" | "TopTwelveHour" | "TopThreeMonths" | "TopSixMonths" | "TopNineMonths" | "Controversial" | "Scaled" */ = null,
    val show_nsfw: Boolean? = null,
    val page: Int? = null,
    val limit: Int? = null,
)
