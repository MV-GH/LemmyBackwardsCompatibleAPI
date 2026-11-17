package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.enums.ListingType
import it.vercruysse.lemmyapi.enums.SortType
import kotlinx.serialization.Serializable

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
    val creator_id: PersonId? = null,
    /** Added in 1.0.0 */
    val creator_username: String? = null,
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
    val hide_posts_with_media: Boolean? = null,
    /** Added in 1.0.0 */
    val mark_as_read: Boolean? = null,
    /** Added in 1.0.0 */
    val no_comments_only: Boolean? = null,
    /** Added in 1.0.0 */
    val search_term: String? = null,
    /** Added in 1.0.0 */
    val search_title_only: Boolean? = null,
    /** Added in 1.0.0 */
    val search_url_only: Boolean? = null,
    /** Added in 1.0.0 */
    val tag_id: CommunityTagId? = null,
    val page_cursor: PaginationCursor? = null,
    val limit: Long? = null,
) : DatatypeRoot
