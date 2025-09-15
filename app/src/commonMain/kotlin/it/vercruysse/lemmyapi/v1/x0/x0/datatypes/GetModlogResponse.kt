package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import it.vercruysse.lemmyapi.v1.x0.x0.combinedtypes.ModlogCombinedView
import kotlinx.serialization.Serializable

@Serializable
internal data class GetModlogResponse(
    val modlog: List<ModlogCombinedView>,
    val next_page: PaginationCursor? = null,
    val prev_page: PaginationCursor? = null,
)
