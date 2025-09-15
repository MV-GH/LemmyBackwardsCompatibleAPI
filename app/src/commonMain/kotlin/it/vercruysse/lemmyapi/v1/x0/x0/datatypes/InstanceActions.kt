package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class InstanceActions(
    val blocked_communities_at: String? = null,
    val received_ban_at: String? = null,
    val ban_expires_at: String? = null,
    val blocked_persons_at: String? = null,
)
