package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import it.vercruysse.lemmyapi.dto.CommentSortType
import it.vercruysse.lemmyapi.dto.ListingType
import kotlinx.serialization.Serializable

@Serializable
internal data class GetComments(
    val type_: ListingType? /* "All" | "Local" | "Subscribed" | "ModeratorView" */ = null,
    val sort: CommentSortType? /* "Hot" | "Top" | "New" | "Old" | "Controversial" */ = null,
    val time_range_seconds: Long? = null,
    val max_depth: Long? = null,
    val page_cursor: PaginationCursor? = null,
    val page_back: Boolean? = null,
    val limit: Long? = null,
    val community_id: CommunityId? = null,
    val community_name: String? = null,
    val post_id: PostId? = null,
    val parent_id: CommentId? = null,
    val liked_only: Boolean? = null,
    val disliked_only: Boolean? = null,
)
