package it.vercruysse.lemmyapi.v0.x19.x6.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class GetPostsResponse(
    val posts: List<PostView>,
    val next_page: PaginationCursor? = null,
)
