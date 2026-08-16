package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.enums.ListingType
import it.vercruysse.lemmyapi.enums.SearchType
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class Search(
    val search_term: String,
    val community_id: CommunityId? = null,
    val community_name: String? = null,
    val creator_id: PersonId? = null,
    /** Added in 1.0.0 */
    val creator_username: String? = null,
    val type_: SearchType? /* "All" | "Comments" | "Posts" | "Communities" | "Users" | "Url" */ = null,
    val time_range_seconds: Long? = null,
    val listing_type: ListingType? /* "All" | "Local" | "Subscribed" | "ModeratorView" */ = null,
    /** Removed in 1.0.0 */
    val page: Long? = null,
    /** Added in 0.19.6 */
    val title_only: Boolean? = null,
    /** Added in 1.0.0 */
    val post_url_only: Boolean? = null,
    /** Added in 1.0.0 */
    val show_nsfw: Boolean? = null,
    /** Added in 1.0.0 */
    val page_cursor: PaginationCursor? = null,
    val limit: Long? = null,
) : DatatypeRoot
