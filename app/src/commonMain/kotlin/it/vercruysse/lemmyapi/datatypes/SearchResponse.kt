package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize


@CommonParcelize
@Serializable
data class SearchResponse(
    val results: List<SearchCombinedView>,
    /** Added in 1.0.0 */
    val next_page: PaginationCursor? = null,
    /** Added in 1.0.0 */
    val prev_page: PaginationCursor? = null,
) : DatatypeRoot
