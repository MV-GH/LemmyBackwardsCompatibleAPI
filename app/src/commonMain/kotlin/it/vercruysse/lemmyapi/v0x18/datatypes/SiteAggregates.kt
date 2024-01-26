package it.vercruysse.lemmyapi.v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class SiteAggregates(
    val id: Long,
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
