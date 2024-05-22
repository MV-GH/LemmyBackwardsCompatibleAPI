package it.vercruysse.lemmyapi.v0x19x5.datatypes

import it.vercruysse.lemmyapi.dto.CommentSortType
import kotlinx.serialization.Serializable

@Serializable
data class GetReplies(
    val sort: CommentSortType? /* "Hot" | "Top" | "New" | "Old" | "Controversial" */ = null,
    val page: Long? = null,
    val limit: Long? = null,
    val unread_only: Boolean? = null,
)
