package v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class GetPostsResponse(
    val posts: List<PostView>,
)
