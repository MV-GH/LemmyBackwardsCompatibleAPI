package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class FederatedInstances(
    val linked: List<InstanceWithFederationState>,
    val allowed: List<InstanceWithFederationState>,
    val blocked: List<InstanceWithFederationState>,
)
