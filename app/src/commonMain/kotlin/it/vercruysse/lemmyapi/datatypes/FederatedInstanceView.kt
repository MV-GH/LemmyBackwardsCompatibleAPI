package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class FederatedInstanceView(
    val instance: Instance,
    val site: Site? = null,
    val queue_state: FederationQueueState? = null,
    val blocked: FederationBlockList? = null,
    val allowed: FederationAllowList? = null,
) : DatatypeRoot
