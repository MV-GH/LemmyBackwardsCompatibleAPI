package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class UnreadCountsResponse(
    val notification_count: Long,
    val report_count: Long? = null,
    val pending_follow_count: Long? = null,
    val registration_application_count: Long? = null,
) : DatatypeRoot
