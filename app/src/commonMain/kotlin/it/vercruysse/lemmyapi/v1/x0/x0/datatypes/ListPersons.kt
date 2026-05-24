package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import it.vercruysse.lemmyapi.enums.ListingType
import it.vercruysse.lemmyapi.enums.PersonSortType
import kotlinx.serialization.Serializable

@Serializable
internal data class ListPersons(
    val type_: ListingType? /* "all" | "local" */ = null,
    val sort: PersonSortType? /* "new" | "old" | "post_score" | "comment_score" */ = null,
    val search_term: String? = null,
    val search_title_only: Boolean? = null,
    val page_cursor: PaginationCursor? = null,
    val limit: Long? = null,
)
