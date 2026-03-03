package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import it.vercruysse.lemmyapi.v1.x0.x0.combinedtypes.SearchCombinedView
import kotlinx.serialization.Serializable

@Serializable
internal data class SearchResponse(
    val resolve: SearchCombinedView? = null,
    val search: List<SearchCombinedView>,
    val next_page: PaginationCursor? = null,
    val prev_page: PaginationCursor? = null,
)
