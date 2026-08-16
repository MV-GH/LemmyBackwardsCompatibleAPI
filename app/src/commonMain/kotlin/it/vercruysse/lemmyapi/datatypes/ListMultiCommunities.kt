package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.enums.MultiCommunityListingType
import it.vercruysse.lemmyapi.enums.MultiCommunitySortType
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class ListMultiCommunities(
    val type_: MultiCommunityListingType? /* "all" | "local" | "subscribed" */ = null,
    val sort: MultiCommunitySortType? /* "new" | "old" | "name_asc" | "name_desc" | "communities" | "subscribers" | "subscribers_local" */ = null,
    val creator_id: PersonId? = null,
    val time_range_seconds: Long? = null,
    val search_term: String? = null,
    val search_title_only: Boolean? = null,
    val page_cursor: PaginationCursor? = null,
    val limit: Long? = null,
) : DatatypeRoot
