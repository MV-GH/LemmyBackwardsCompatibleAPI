package it.vercruysse.lemmyapi.v0x18.datatypes

import it.vercruysse.lemmyapi.dto.CommentSortType
import it.vercruysse.lemmyapi.dto.ListingType
import kotlinx.serialization.Serializable

@Serializable
internal data class GetComments(
    val type_: ListingType? /* "All" | "Local" | "Subscribed" */ = null,
    val sort: CommentSortType? /* "Hot" | "Top" | "New" | "Old" */ = null,
    val max_depth: Int? = null,
    val page: Int? = null,
    val limit: Int? = null,
    val community_id: CommunityId? = null,
    val community_name: String? = null,
    val post_id: PostId? = null,
    val parent_id: CommentId? = null,
    val saved_only: Boolean? = null,
    val auth: String? = null,
)
