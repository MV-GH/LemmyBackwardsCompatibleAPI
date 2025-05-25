package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.dto.SortType
import it.vercruysse.lemmyapi.dto.ListingType
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.dto.PAGE_CURSOR_GUARD

// TODO: many changes

@CommonParcelize
@Serializable
data class GetPosts(
    val type_: ListingType? /* "All" | "Local" | "Subscribed" | "ModeratorView" */ = null,
    val sort: SortType? /* "Active" | "Hot" | "New" | "Old" | "TopDay" | "TopWeek" | "TopMonth" | "TopYear" | "TopAll" | "MostComments" | "NewComments" | "TopHour" | "TopSixHour" | "TopTwelveHour" | "TopThreeMonths" | "TopSixMonths" | "TopNineMonths" | "Controversial" | "Scaled" */ = null,
    /* starts from 1, null is considered not set, deprecated 0.19+, set to support 0.18 */
    val page: Long? = null,
    val limit: Long? = null,
    val community_id: CommunityId? = null,
    val community_name: String? = null,
    val saved_only: Boolean? = null,
    val liked_only: Boolean? = null,
    val disliked_only: Boolean? = null,
    val show_hidden: Boolean? = null,
    /** The page cursor to the next list, null is valid and considered first list */
    val page_cursor: PaginationCursor? = PAGE_CURSOR_GUARD, // Guard is used to detect when null is set
    /** Added in 0.19.6 */
    val show_read: Boolean? = null,
    /** Added in 0.19.6 */
    val show_nsfw: Boolean? = null,
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
