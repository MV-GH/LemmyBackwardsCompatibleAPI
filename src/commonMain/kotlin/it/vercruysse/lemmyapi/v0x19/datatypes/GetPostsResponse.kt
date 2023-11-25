package it.vercruysse.lemmyapi.v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class GetPostsResponse(
    val posts: List<PostView>,
    val next_page: PaginationCursor? = null,
)
