package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import it.vercruysse.lemmyapi.enums.ListingType
import it.vercruysse.lemmyapi.enums.SortType
import kotlinx.serialization.Serializable

@Serializable
internal data class GetPosts(
    val type_: ListingType? /* "all" | "local" | "subscribed" | "moderator_view" | "suggested" */ = null,
    val sort: SortType? /* "active" | "hot" | "new" | "old" | "top" | "most_comments" | "new_comments" | "controversial" | "scaled" */ = null,
    val time_range_seconds: Long? = null,
    val community_id: CommunityId? = null,
    val community_name: String? = null,
    val creator_id: PersonId? = null,
    val creator_username: String? = null,
    val multi_community_id: MultiCommunityId? = null,
    val multi_community_name: String? = null,
    val show_hidden: Boolean? = null,
    val show_read: Boolean? = null,
    val show_nsfw: Boolean? = null,
    val hide_media: Boolean? = null,
    val mark_as_read: Boolean? = null,
    val no_comments_only: Boolean? = null,
    val search_term: String? = null,
    val search_title_only: Boolean? = null,
    val search_url_only: Boolean? = null,
    val page_cursor: PaginationCursor? = null,
    val limit: Long? = null,
)
