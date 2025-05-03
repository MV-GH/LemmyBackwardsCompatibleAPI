package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import it.vercruysse.lemmyapi.dto.ListingType
import it.vercruysse.lemmyapi.dto.SortType
import it.vercruysse.lemmyapi.dto.SearchType
import kotlinx.serialization.Serializable

@Serializable
internal data class Search(
    val search_term: String? = null,
    val community_id: CommunityId? = null,
    val community_name: String? = null,
    val creator_id: PersonId? = null,
    val type_: SearchType? /* "All" | "Comments" | "Posts" | "Communities" | "Users" */ = null,
    val sort: SortType? /* "New" | "Top" | "Old" */ = null,
    val time_range_seconds: Long? = null,
    val listing_type: ListingType? /* "All" | "Local" | "Subscribed" | "ModeratorView" */ = null,
    val title_only: Boolean? = null,
    val post_url_only: Boolean? = null,
    val liked_only: Boolean? = null,
    val disliked_only: Boolean? = null,
    val page_cursor: PaginationCursor? = null,
    val page_back: Boolean? = null,
    val limit: Long? = null,
)
