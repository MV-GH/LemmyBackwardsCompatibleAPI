package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class ListPersonContentResponse(
    val content: List<dynamic /* `T$199` & PostView | `T$200` & CommentView */>,
    val next_page: PaginationCursor? = null,
    val prev_page: PaginationCursor? = null,
)
