package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class GetPostsResponse(
    val posts: List<PostView>,
    val next_page: PaginationCursor? = null,
    val prev_page: PaginationCursor? = null,
)
