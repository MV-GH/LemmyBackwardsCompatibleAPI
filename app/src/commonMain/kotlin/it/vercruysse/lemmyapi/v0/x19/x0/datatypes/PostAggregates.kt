package it.vercruysse.lemmyapi.v0.x19.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class PostAggregates(
    val post_id: PostId,
    val comments: Long,
    val score: Long,
    val upvotes: Long,
    val downvotes: Long,
    val published: String,
)
