package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class SearchResponse(
    val results: List<dynamic /* `T$199` & PostView | `T$200` & CommentView | `T$201` & CommunityView | `T$202` & PersonView */>,
    val next_page: PaginationCursor? = null,
    val prev_page: PaginationCursor? = null,
)
