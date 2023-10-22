package v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class PostAggregates(
    val id: Int,
    val post_id: PostId,
    val comments: Int,
    val score: Int,
    val upvotes: Int,
    val downvotes: Int,
    val published: String,
)
