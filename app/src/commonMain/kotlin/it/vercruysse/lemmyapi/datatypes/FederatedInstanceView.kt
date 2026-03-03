package it.vercruysse.lemmyapi.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class FederatedInstanceView(
    val instance: Instance,
    val site: Site? = null,
    val queue_state: FederationQueueState? = null,
    val blocked: FederationBlockList? = null,
    val allowed: FederationAllowList? = null,
)
