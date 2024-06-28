package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@Serializable
data class CommentAggregates(
    val comment_id: CommentId,
    val score: Long,
    val upvotes: Long,
    val downvotes: Long,
    val published: String,
    val child_count: Long,
) : DatatypeRoot
