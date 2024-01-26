package it.vercruysse.lemmyapi.v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class PostAggregates(
    val post_id: PostId,
    val comments: Long,
    val score: Long,
    val upvotes: Long,
    val downvotes: Long,
    val published: String,
)
