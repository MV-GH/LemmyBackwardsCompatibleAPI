package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.enums.PersonContentType
import kotlinx.serialization.Serializable

/**
 * Before Lemmy 1.0, posts and comments are paged separately and combined with comments first.
 * The limit applies to each list, and search and cursor pagination are not supported.
 */
@CommonParcelize
@Serializable
data class ListPersonSaved(
    val type_: PersonContentType? /* "All" | "Comments" | "Posts" */ = null,
    /** Added in 1.0.0 */
    val search_term: String? = null,
    val page_cursor: PaginationCursor? = null,
    val limit: Long? = null,
    /** Removed in 1.0.0 */
    val page: Long? = null,
) : DatatypeRoot
