package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import it.vercruysse.lemmyapi.dto.ListingType
import it.vercruysse.lemmyapi.enums.MultiCommunityListingType
import kotlinx.serialization.Serializable

@Serializable
internal data class ListMultiCommunities(
    val type_: MultiCommunityListingType? /* "all" | "local" | "subscribed" */ = null,
    // TODO: custom sort type
    val sort: String? /* "new" | "old" | "name_asc" | "name_desc" | "communities" | "subscribers" | "subscribers_local" */ = null,
    val creator_id: PersonId? = null,
    val time_range_seconds: Long? = null,
    val page_cursor: PaginationCursor? = null,
    val limit: Long? = null,
)
