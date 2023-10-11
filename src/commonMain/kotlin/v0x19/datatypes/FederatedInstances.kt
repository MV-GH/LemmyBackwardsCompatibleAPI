package v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class FederatedInstances(
    val linked: List<Instance>,
    val allowed: List<Instance>,
    val blocked: List<Instance>,
)
