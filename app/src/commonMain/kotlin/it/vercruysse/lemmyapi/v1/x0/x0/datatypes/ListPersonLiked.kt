package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import it.vercruysse.lemmyapi.enums.PersonContentType
import kotlinx.serialization.Serializable

@Serializable
internal data class ListPersonLiked(
    val type_: PersonContentType? /* "all" | "comments" | "posts" */ = null,
    val like_type: String? /* "all" | "liked_only" | "disliked_only" */ = null,
    val page_cursor: PaginationCursor? = null,
    val limit: Long? = null,
)
