package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class ListPersonContent(
    // TODO: custom enum
    val type_: String? /* "all" | "comments" | "posts" */ = null,
    val person_id: PersonId? = null,
    val username: String? = null,
    val page_cursor: PaginationCursor? = null,
    val limit: Long? = null,
)
