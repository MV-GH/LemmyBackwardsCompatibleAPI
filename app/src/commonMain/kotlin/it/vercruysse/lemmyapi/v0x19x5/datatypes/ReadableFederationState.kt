package it.vercruysse.lemmyapi.v0x19x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class ReadableFederationState(
    val instance_id: InstanceId,
    val last_successful_id: ActivityId? = null,
    val last_successful_published_time: String? = null,
    val fail_count: Long,
    val last_retry: String? = null,
    val next_retry: String? = null,
)
