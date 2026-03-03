package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.dto.ListingType
import it.vercruysse.lemmyapi.dto.SortType
import it.vercruysse.lemmyapi.dto.SearchType
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

@CommonParcelize
@Serializable
data class Search(
    val q: String,
    val community_id: CommunityId? = null,
    val community_name: String? = null,
    val creator_id: PersonId? = null,
    val type_: SearchType? /* "All" | "Comments" | "Posts" | "Communities" | "Users" | "Url" */ = null,
    val sort: SortType? /* "Active" | "Hot" | "New" | "Old" | "TopDay" | "TopWeek" | "TopMonth" | "TopYear" | "TopAll" | "MostComments" | "NewComments" | "TopHour" | "TopSixHour" | "TopTwelveHour" | "TopThreeMonths" | "TopSixMonths" | "TopNineMonths" | "Controversial" | "Scaled" */ = null,
    val time_range_seconds: Long? = null,
    val listing_type: ListingType? /* "All" | "Local" | "Subscribed" | "ModeratorView" */ = null,
    /** Removed in 1.0.0 */
    val page: Long? = null,
    /** Added in 0.19.6 */
    val title_only: Boolean? = null,
    /** Added in 1.0.0 */
    val post_url_only: Boolean? = null,
    /** Added in 1.0.0 */
    val liked_only: Boolean? = null,
    /** Added in 1.0.0 */
    val disliked_only: Boolean? = null,
    /** Added in 1.0.0 */
    val show_nsfw: Boolean? = null,
    /** Added in 1.0.0 */
    val page_cursor: PaginationCursor? = null,
    val limit: Long? = null,
) : DatatypeRoot
