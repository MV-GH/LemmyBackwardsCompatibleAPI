package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.dto.SortType
import it.vercruysse.lemmyapi.dto.ListingType
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.dto.PAGE_CURSOR_GUARD


@CommonParcelize
@Serializable
data class GetPosts(
    val type_: ListingType? /* "All" | "Local" | "Subscribed" | "ModeratorView" */ = null,
    val sort: SortType? /* "Active" | "Hot" | "New" | "Old" | "TopDay" | "TopWeek" | "TopMonth" | "TopYear" | "TopAll" | "MostComments" | "NewComments" | "TopHour" | "TopSixHour" | "TopTwelveHour" | "TopThreeMonths" | "TopSixMonths" | "TopNineMonths" | "Controversial" | "Scaled" */ = null,
    /** Added in 1.0.0 */
    val time_range_seconds: Long? = null,
    val community_id: CommunityId? = null,
    val community_name: String? = null,
    /** Added in 1.0.0 */
    val multi_community_id: MultiCommunityId? = null,
    /** Added in 1.0.0 */
    val multi_community_name: String? = null,
    val show_hidden: Boolean? = null,
    /** Added in 0.19.6 */
    val show_read: Boolean? = null,
    /** Added in 0.19.6 */
    val show_nsfw: Boolean? = null,
    /** Added in 1.0.0 */
    val hide_media: Boolean? = null,
    /** Added in 1.0.0 */
    val mark_as_read: Boolean? = null,
    /** Added in 1.0.0 */
    val no_comments_only: Boolean? = null,
    /** The page cursor to the next list, null is valid and considered first list */
    val page_cursor: PaginationCursor? = PAGE_CURSOR_GUARD, // Guard is used to detect when null is set
    /** starts from 1, null is considered not set, deprecated 0.19+, set to support 0.18, removed in 1.0.0 */
    val page: Long? = null,
    val limit: Long? = null,
) : DatatypeRoot {

    internal fun toPostsForm(): GetPosts {
        return this.copy(page_cursor = null, page = this.page)
    }

    internal fun toValidatedForm(): GetPosts {
        val pageCursorSet = this.page_cursor != PAGE_CURSOR_GUARD

        return if (pageCursorSet) {
            this.copy(page_cursor = this.page_cursor, page = null)
        } else {
            this.copy(page_cursor = null, page = this.page)
        }

    }
}
