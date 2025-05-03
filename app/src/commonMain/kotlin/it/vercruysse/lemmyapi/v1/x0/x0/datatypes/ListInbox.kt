package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import it.vercruysse.lemmyapi.dto.ListingType
import kotlinx.serialization.Serializable

@Serializable
internal data class ListInbox(
    val type_: ListingType? /* "All" | "CommentReply" | "CommentMention" | "PostMention" | "PrivateMessage" */ = null,
    val unread_only: Boolean? = null,
    val page_cursor: PaginationCursor? = null,
    val page_back: Boolean? = null,
    val limit: Long? = null,
)
