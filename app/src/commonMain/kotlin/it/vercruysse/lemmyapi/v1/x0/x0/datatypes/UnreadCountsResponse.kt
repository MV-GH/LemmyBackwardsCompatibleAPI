package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class UnreadCountsResponse(
    val notification_count: Long,
    val report_count: Long? = null,
    val pending_follow_count: Long? = null,
    val registration_application_count: Long? = null,
)
