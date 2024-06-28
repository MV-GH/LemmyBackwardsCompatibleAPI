package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@Serializable
data class PostAggregates(
    val post_id: PostId,
    val comments: Long,
    val score: Long,
    val upvotes: Long,
    val downvotes: Long,
    val published: String,
    val newest_comment_time: String,
) : DatatypeRoot
