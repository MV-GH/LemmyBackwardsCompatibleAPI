package it.vercruysse.lemmyapi.v0.x18.x5.datatypes

import it.vercruysse.lemmyapi.dto.ListingType
import it.vercruysse.lemmyapi.dto.SortType
import kotlinx.serialization.Serializable

@Serializable
internal data class ListCommunities(
    val type_: ListingType? /* "All" | "Local" | "Subscribed" */ = null,
    val sort: SortType? /* "Active" | "Hot" | "New" | "Old" | "TopDay" | "TopWeek" | "TopMonth" | "TopYear" | "TopAll" | "MostComments" | "NewComments" | "TopHour" | "TopSixHour" | "TopTwelveHour" | "TopThreeMonths" | "TopSixMonths" | "TopNineMonths" */ = null,
    val show_nsfw: Boolean? = null,
    val page: Long? = null,
    val limit: Long? = null,
    val auth: String? = null,
)
