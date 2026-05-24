package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import it.vercruysse.lemmyapi.enums.ListingType
import it.vercruysse.lemmyapi.enums.SearchType
import kotlinx.serialization.Serializable

@Serializable
internal data class Search(
    val search_term: String,
    val community_id: CommunityId? = null,
    val community_name: String? = null,
    val creator_id: PersonId? = null,
    val creator_username: String? = null,
    val type_: SearchType? /* "all" | "comments" | "posts" | "communities" | "users" | "multi_communities" */ = null,
    val time_range_seconds: Long? = null,
    val listing_type: ListingType? /* "all" | "local" | "subscribed" | "moderator_view" | "suggested" */ = null,
    val title_only: Boolean? = null,
    val post_url_only: Boolean? = null,
    val show_nsfw: Boolean? = null,
    val page_cursor: PaginationCursor? = null,
    val limit: Long? = null,
)
