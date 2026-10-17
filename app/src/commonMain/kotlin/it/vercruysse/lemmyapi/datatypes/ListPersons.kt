package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.enums.ListingType
import it.vercruysse.lemmyapi.enums.PersonSortType
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class ListPersons(
    val type_: ListingType? /* "all" | "local" */ = null,
    val sort: PersonSortType? /* "new" | "old" | "post_score" | "comment_score" */ = null,
    val search_term: String? = null,
    val search_title_only: Boolean? = null,
    /** Added in Lemmy 1.0.0 */
    val community_id: CommunityId? = null,
    val page_cursor: PaginationCursor? = null,
    val limit: Long? = null,
) : DatatypeRoot
