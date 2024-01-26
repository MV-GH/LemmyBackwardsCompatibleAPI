package it.vercruysse.lemmyapi.v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class CommentAggregates(
    val id: Long,
    val comment_id: CommentId,
    val score: Long,
    val upvotes: Long,
    val downvotes: Long,
    val published: String,
    val child_count: Long,
    val hot_rank: Long,
)
