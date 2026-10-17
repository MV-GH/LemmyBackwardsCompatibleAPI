package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class FederatedInstanceView(
    val instance: Instance,
    val site: Site? = null,
    val queue_state: FederationQueueState? = null,
    val blocked: FederationBlockList? = null,
    val allowed: FederationAllowList? = null,
)
