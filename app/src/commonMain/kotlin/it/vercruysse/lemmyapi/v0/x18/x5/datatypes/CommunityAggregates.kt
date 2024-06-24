package it.vercruysse.lemmyapi.v0.x18.x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class CommunityAggregates(
    val id: Long,
    val community_id: CommunityId,
    val subscribers: Long,
    val posts: Long,
    val comments: Long,
    val published: String,
    val users_active_day: Long,
    val users_active_week: Long,
    val users_active_month: Long,
    val users_active_half_year: Long,
    val hot_rank: Long,
)
