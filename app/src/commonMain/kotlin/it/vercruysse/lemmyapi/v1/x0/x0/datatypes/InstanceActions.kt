package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class InstanceActions(
    val person_id: PersonId,
    val instance_id: InstanceId,
    val blocked: String? = null,
    val received_ban: String? = null,
    val ban_expires: String? = null,
)
