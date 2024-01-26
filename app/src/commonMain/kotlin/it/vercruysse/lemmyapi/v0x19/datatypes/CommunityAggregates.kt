package it.vercruysse.lemmyapi.v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class CommunityAggregates(
    val community_id: CommunityId,
    val subscribers: Long,
    val posts: Long,
    val comments: Long,
    val published: String,
    val users_active_day: Long,
    val users_active_week: Long,
    val users_active_month: Long,
    val users_active_half_year: Long,
    val subscribers_local: Long? = null,
)
