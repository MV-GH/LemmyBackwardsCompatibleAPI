package it.vercruysse.lemmyapi.v0x19.datatypes

import it.vercruysse.lemmyapi.dto.CommentSortType
import it.vercruysse.lemmyapi.dto.ListingType
import kotlinx.serialization.Serializable

@Serializable
data class GetComments(
    val type_: ListingType? /* "All" | "Local" | "Subscribed" | "ModeratorView" */ = null,
    val sort: CommentSortType? /* "Hot" | "Top" | "New" | "Old" | "Controversial" */ = null,
    val max_depth: Int? = null,
    val page: Int? = null,
    val limit: Int? = null,
    val community_id: CommunityId? = null,
    val community_name: String? = null,
    val post_id: PostId? = null,
    val parent_id: CommentId? = null,
    val saved_only: Boolean? = null,
    val liked_only: Boolean? = null,
    val disliked_only: Boolean? = null,
)
