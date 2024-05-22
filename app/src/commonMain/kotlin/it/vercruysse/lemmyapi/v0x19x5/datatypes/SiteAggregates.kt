package it.vercruysse.lemmyapi.v0x19x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class SiteAggregates(
    val site_id: SiteId,
    val users: Long,
    val posts: Long,
    val comments: Long,
    val communities: Long,
    val users_active_day: Long,
    val users_active_week: Long,
    val users_active_month: Long,
    val users_active_half_year: Long,
)
