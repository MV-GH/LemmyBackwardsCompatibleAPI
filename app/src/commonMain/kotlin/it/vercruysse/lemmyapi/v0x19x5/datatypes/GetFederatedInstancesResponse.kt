package it.vercruysse.lemmyapi.v0x19x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class GetFederatedInstancesResponse(
    val federated_instances: FederatedInstances? = null,
)
