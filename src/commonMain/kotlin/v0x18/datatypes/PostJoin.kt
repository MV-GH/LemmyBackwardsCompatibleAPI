package v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class PostJoin(
    val post_id: PostId,
)
