package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.enums.MultiCommunityListingType
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class ListMultiCommunities(
    val type_: MultiCommunityListingType? /* "all" | "local" | "subscribed" */ = null,
    // TODO: custom sort type
    val sort: String? /* "new" | "old" | "name_asc" | "name_desc" | "communities" | "subscribers" | "subscribers_local" */ = null,
    val creator_id: PersonId? = null,
    val time_range_seconds: Long? = null,
    val page_cursor: PaginationCursor? = null,
    val limit: Long? = null,
) : DatatypeRoot
