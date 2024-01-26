package it.vercruysse.lemmyapi.v0x18.datatypes

import it.vercruysse.lemmyapi.dto.CommentSortType
import kotlinx.serialization.Serializable

@Serializable
internal data class GetReplies(
    val sort: CommentSortType? /* "Hot" | "Top" | "New" | "Old" */ = null,
    val page: Long? = null,
    val limit: Long? = null,
    val unread_only: Boolean? = null,
    val auth: String,
)
