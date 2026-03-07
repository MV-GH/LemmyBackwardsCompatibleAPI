package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import it.vercruysse.lemmyapi.enums.MultiCommunityListingType
import it.vercruysse.lemmyapi.enums.MultiCommunitySortType
import kotlinx.serialization.Serializable

@Serializable
internal data class ListMultiCommunities(
    val type_: MultiCommunityListingType? /* "all" | "local" | "subscribed" */ = null,
    val sort: MultiCommunitySortType? /* "new" | "old" | "name_asc" | "name_desc" | "communities" | "subscribers" | "subscribers_local" */ = null,
    val creator_id: PersonId? = null,
    val time_range_seconds: Long? = null,
    val page_cursor: PaginationCursor? = null,
    val limit: Long? = null,
)
