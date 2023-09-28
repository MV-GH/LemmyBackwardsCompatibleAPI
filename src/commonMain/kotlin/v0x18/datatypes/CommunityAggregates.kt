package v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class CommunityAggregates(
    val id: Int,
    val community_id: CommunityId,
    val subscribers: Int,
    val posts: Int,
    val comments: Int,
    val published: String,
    val users_active_day: Int,
    val users_active_week: Int,
    val users_active_month: Int,
    val users_active_half_year: Int,
    val hot_rank: Int,
)
