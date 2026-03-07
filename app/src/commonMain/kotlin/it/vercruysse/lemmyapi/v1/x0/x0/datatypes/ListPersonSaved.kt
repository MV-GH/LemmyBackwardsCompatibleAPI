package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import it.vercruysse.lemmyapi.enums.PersonContentType
import kotlinx.serialization.Serializable

@Serializable
internal data class ListPersonSaved(
    val type_: PersonContentType? /* "all" | "comments" | "posts" */ = null,
    val page_cursor: PaginationCursor? = null,
    val limit: Long? = null,
)
