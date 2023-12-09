package it.vercruysse.lemmyapi.v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class CommentAggregates(
    val comment_id: CommentId,
    val score: Int,
    val upvotes: Int,
    val downvotes: Int,
    val published: String,
    val child_count: Int,
)
