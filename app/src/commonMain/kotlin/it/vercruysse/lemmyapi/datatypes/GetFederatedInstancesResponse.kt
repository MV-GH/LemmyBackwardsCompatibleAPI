package it.vercruysse.lemmyapi.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class GetFederatedInstancesResponse(
    val federated_instances: FederatedInstances? = null,
)
