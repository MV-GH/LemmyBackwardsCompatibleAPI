package v0x18.datatypes

import CommentSortType
import kotlinx.serialization.Serializable

@Serializable
data class GetReplies(
    val sort: CommentSortType? /* "Hot" | "Top" | "New" | "Old" */ = null,
    val page: Int? = null,
    val limit: Int? = null,
    val unread_only: Boolean? = null,
    val auth: String,
)
