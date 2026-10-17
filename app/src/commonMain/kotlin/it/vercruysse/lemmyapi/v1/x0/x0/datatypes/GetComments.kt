package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import it.vercruysse.lemmyapi.enums.CommentSortType
import it.vercruysse.lemmyapi.enums.ListingType
import kotlinx.serialization.Serializable

@Serializable
internal data class GetComments(
    val type_: ListingType? /* "all" | "local" | "subscribed" | "moderator_view" | "suggested" */ = null,
    val sort: CommentSortType? /* "hot" | "top" | "new" | "old" | "controversial" */ = null,
    val time_range_seconds: Long? = null,
    val max_depth: Long? = null,
    val page_cursor: PaginationCursor? = null,
    val limit: Long? = null,
    val community_id: CommunityId? = null,
    val community_name: String? = null,
    val creator_id: PersonId? = null,
    val creator_username: String? = null,
    val post_id: PostId? = null,
    val parent_id: CommentId? = null,
    val search_term: String? = null,
)
