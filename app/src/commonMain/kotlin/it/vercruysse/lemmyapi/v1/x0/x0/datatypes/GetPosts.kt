package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import it.vercruysse.lemmyapi.dto.SortType
import it.vercruysse.lemmyapi.dto.ListingType
import kotlinx.serialization.Serializable

@Serializable
internal data class GetPosts(
    val type_: ListingType? /* "All" | "Local" | "Subscribed" | "ModeratorView" */ = null,
    val sort: SortType? /* "Active" | "Hot" | "New" | "Old" | "Top" | "MostComments" | "NewComments" | "Controversial" | "Scaled" */ = null,
    val time_range_seconds: Long? = null,
    val community_id: CommunityId? = null,
    val community_name: String? = null,
    val liked_only: Boolean? = null,
    val disliked_only: Boolean? = null,
    val show_hidden: Boolean? = null,
    val show_read: Boolean? = null,
    val show_nsfw: Boolean? = null,
    val hide_media: Boolean? = null,
    val mark_as_read: Boolean? = null,
    val no_comments_only: Boolean? = null,
    val page_cursor: PaginationCursor? = null,
    val page_back: Boolean? = null,
    val limit: Long? = null,
)
