package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class ListMediaResponse(
    val images: List<LocalImageView>,
    val next_page: PaginationCursor? = null,
    val prev_page: PaginationCursor? = null,
)
