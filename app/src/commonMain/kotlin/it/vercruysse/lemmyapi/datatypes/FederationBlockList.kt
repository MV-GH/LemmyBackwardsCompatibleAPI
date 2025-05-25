package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.v1.x0.x0.datatypes.InstanceId
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class FederationBlockList(
    val instance_id: InstanceId,
    val published: String,
    val updated: String? = null,
    val expires: String? = null,
): DatatypeRoot
