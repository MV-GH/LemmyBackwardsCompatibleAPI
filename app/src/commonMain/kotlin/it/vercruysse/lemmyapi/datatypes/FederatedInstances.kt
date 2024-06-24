package it.vercruysse.lemmyapi.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class FederatedInstances(
    val linked: List<InstanceWithFederationState>,
    val allowed: List<InstanceWithFederationState>,
    val blocked: List<InstanceWithFederationState>,
)
