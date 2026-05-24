package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.enums.SortType
import it.vercruysse.lemmyapi.enums.ListingType
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

@CommonParcelize
@Serializable
data class ListCommunities(
    val type_: ListingType? /* "all" | "local" | "subscribed" | "moderator_view" | "suggested" */ = null,
    val sort: SortType? /* "active_six_months" | "active_monthly" | "active_weekly" | "active_daily" | "hot" | "new" | "old" | "name_asc" | "name_desc" | "comments" | "posts" | "subscribers" | "subscribers_local" */ = null,
    val time_range_seconds: Long? = null,
    val show_nsfw: Boolean? = null,
    /** Added in 1.0.0 */
    val multi_community_id: MultiCommunityId? = null,
    /** Added in 1.0.0 */
    val search_term: String? = null,
    /** Added in 1.0.0 */
    val search_title_only: Boolean? = null,
    /** Added in 1.0.0 */
    val page_cursor: PaginationCursor? = null,
    /** Removed in 1.0.0 */
    val page: Long? = null,
    val limit: Long? = null,
) : DatatypeRoot
