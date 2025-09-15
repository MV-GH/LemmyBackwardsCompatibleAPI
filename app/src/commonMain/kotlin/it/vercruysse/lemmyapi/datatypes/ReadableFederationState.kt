package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

@CommonParcelize
@Serializable
data class ReadableFederationState(
    val instance_id: InstanceId,
    val last_successful_id: ActivityId? = null,
    val last_successful_published_time_at: String? = null,
    val fail_count: Long,
    val last_retry_at: String? = null,
    val next_retry_at: String? = null,
) : DatatypeRoot
