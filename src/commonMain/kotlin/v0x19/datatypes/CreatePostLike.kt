package v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class CreatePostLike(
    val post_id: PostId,
    val score: Int,
)
