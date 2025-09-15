package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import it.vercruysse.lemmyapi.v1.x0.x0.combinedtypes.PersonLikedCombinedView
import kotlinx.serialization.Serializable

@Serializable
internal data class ListPersonLikedResponse(
    val liked: List<PersonLikedCombinedView>,
    val next_page: PaginationCursor? = null,
    val prev_page: PaginationCursor? = null,
)
