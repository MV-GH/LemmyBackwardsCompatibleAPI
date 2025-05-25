package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

// TODO: changed, prob flat pressed

@CommonParcelize
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
    val subscribers_local: Long,
) : DatatypeRoot
