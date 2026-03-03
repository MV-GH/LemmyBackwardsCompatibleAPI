package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import it.vercruysse.lemmyapi.enums.ListingType
import it.vercruysse.lemmyapi.enums.SortType
import it.vercruysse.lemmyapi.enums.SearchType
import kotlinx.serialization.Serializable

@Serializable
internal data class Search(
    val q: String,
    val community_id: CommunityId? = null,
    val community_name: String? = null,
    val creator_id: PersonId? = null,
    val type_: SearchType? /* "all" | "comments" | "posts" | "communities" | "users" | "multi_communities" */ = null,
    val sort: SortType? /* "new" | "top" | "old" */ = null,
    val time_range_seconds: Long? = null,
    val listing_type: ListingType? /* "all" | "local" | "subscribed" | "moderator_view" | "suggested" */ = null,
    val title_only: Boolean? = null,
    val post_url_only: Boolean? = null,
    val liked_only: Boolean? = null,
    val disliked_only: Boolean? = null,
    val show_nsfw: Boolean? = null,
    val page_cursor: PaginationCursor? = null,
    val limit: Long? = null,
)
