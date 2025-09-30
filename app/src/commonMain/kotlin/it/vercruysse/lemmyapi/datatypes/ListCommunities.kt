package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.dto.SortType
import it.vercruysse.lemmyapi.dto.ListingType
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

@CommonParcelize
@Serializable
data class ListCommunities(
    val show_nsfw: Boolean? = null,
    val type_: ListingType? /* "All" | "Local" | "Subscribed" | "ModeratorView" */ = null,
    val sort: SortType? /* "Active" | "Hot" | "New" | "Old" | "TopDay" | "TopWeek" | "TopMonth" | "TopYear" | "TopAll" | "MostComments" | "NewComments" | "TopHour" | "TopSixHour" | "TopTwelveHour" | "TopThreeMonths" | "TopSixMonths" | "TopNineMonths" | "Controversial" | "Scaled" */ = null,
    /** Added in 1.0.0 */
    val page_cursor: PaginationCursor? = null,
    /** Added in 1.0.0 */
    val page_back: Boolean? = null,
    /** Removed in 1.0.0 */
    val page: Long? = null,
    val limit: Long? = null,
) : DatatypeRoot
