package it.vercruysse.lemmyapi.v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class CommentAggregates(
    val id: Int,
    val comment_id: CommentId,
    val score: Int,
    val upvotes: Int,
    val downvotes: Int,
    val published: String,
    val child_count: Int,
    val hot_rank: Int,
)
