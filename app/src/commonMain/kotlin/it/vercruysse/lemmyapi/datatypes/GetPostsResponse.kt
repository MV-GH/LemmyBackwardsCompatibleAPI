package it.vercruysse.lemmyapi.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class GetPostsResponse(
    val posts: List<PostView>,
    val next_page: PaginationCursor? = null,
)
