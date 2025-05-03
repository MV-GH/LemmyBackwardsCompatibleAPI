package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class ListMedia(
    val page_cursor: PaginationCursor? = null,
    val page_back: Boolean? = null,
    val limit: Long? = null,
)
