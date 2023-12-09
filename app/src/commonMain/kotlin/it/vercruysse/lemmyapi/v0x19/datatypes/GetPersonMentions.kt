package it.vercruysse.lemmyapi.v0x19.datatypes

import it.vercruysse.lemmyapi.dto.CommentSortType
import kotlinx.serialization.Serializable

@Serializable
data class GetPersonMentions(
    val sort: CommentSortType? /* "Hot" | "Top" | "New" | "Old" | "Controversial" */ = null,
    val page: Int? = null,
    val limit: Int? = null,
    val unread_only: Boolean? = null,
)
