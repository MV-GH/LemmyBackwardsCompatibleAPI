package it.vercruysse.lemmyapi.v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class CommunityAggregates(
    val community_id: CommunityId,
    val subscribers: Int,
    val posts: Int,
    val comments: Int,
    val published: String,
    val users_active_day: Int,
    val users_active_week: Int,
    val users_active_month: Int,
    val users_active_half_year: Int,
    val subscribers_local: Int?,
)
