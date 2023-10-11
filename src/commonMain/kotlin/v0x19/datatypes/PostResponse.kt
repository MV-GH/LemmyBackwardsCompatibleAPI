package v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class PostResponse(
    val post_view: PostView,
)
