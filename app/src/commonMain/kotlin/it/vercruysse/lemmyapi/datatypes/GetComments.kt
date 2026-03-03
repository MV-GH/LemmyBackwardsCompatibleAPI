package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.dto.CommentSortType
import it.vercruysse.lemmyapi.dto.ListingType
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

@CommonParcelize
@Serializable
data class GetComments(
    val type_: ListingType? /* "All" | "Local" | "Subscribed" | "ModeratorView" | "Suggested" */ = null,
    val sort: CommentSortType? /* "Hot" | "Top" | "New" | "Old" | "Controversial" */ = null,
    /** Added in 1.0.0 */
    val time_range_seconds: Long? = null,
    val max_depth: Long? = null,
    /** Added in 1.0.0 */
    val page_cursor: PaginationCursor? = null,
    /** Removed in 1.0.0 */
    val page: Long? = null,
    val limit: Long? = null,
    val community_id: CommunityId? = null,
    val community_name: String? = null,
    val post_id: PostId? = null,
    val parent_id: CommentId? = null,
    /** Removed in 1.0.0 */
    val saved_only: Boolean? = null,
    /** Removed in 1.0.0 */
    val liked_only: Boolean? = null,
    /** Removed in 1.0.0 */
    val disliked_only: Boolean? = null,
) : DatatypeRoot
