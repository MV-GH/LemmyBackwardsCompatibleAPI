package it.vercruysse.lemmyapi.v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class FederatedInstances(
    val linked: List<Instance>,
    val allowed: List<Instance>,
    val blocked: List<Instance>,
)
