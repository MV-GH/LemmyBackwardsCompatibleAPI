package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class ReadableFederationState(
    val next_retry: String? = null,
    val instance_id: InstanceId,
    val last_successful_id: ActivityId? = null,
    val last_successful_published_time: String? = null,
    val fail_count: Long,
    val last_retry: String? = null,
)
