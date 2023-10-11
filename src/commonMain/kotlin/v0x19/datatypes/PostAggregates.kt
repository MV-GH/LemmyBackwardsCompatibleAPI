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
    val newest_comment_time_necro: String,
    val newest_comment_time: String,
    val featured_community: Boolean,
    val featured_local: Boolean,
    val hot_rank: Float,
    val hot_rank_active: Float,
    val community_id: CommunityId,
    val creator_id: PersonId,
    val controversy_rank: Int,
    val instance_id: InstanceId,
    val scaled_rank: Int,
)
