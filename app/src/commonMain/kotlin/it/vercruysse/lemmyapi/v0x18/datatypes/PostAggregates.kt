package it.vercruysse.lemmyapi.v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class PostAggregates(
    val id: Int,
    val post_id: PostId,
    val comments: Int,
    val score: Int,
    val upvotes: Int,
    val downvotes: Int,
    val published: String,
    val newest_comment_time_necro: String,
    val newest_comment_time: String,
    val featured_community: Boolean,
    val featured_local: Boolean,
    val hot_rank: Int,
    val hot_rank_active: Int,
    val community_id: Int? = null,
    val creator_id: Int? = null,
)
