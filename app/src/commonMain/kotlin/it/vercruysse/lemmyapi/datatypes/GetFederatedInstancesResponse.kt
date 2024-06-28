package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@Serializable
data class GetFederatedInstancesResponse(
    val federated_instances: FederatedInstances? = null,
) : DatatypeRoot
