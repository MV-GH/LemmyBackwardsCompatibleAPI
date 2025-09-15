package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class FederationBlockList(
    val instance_id: InstanceId,
    val published_at: String,
    val updated_at: String? = null,
    val expires_at: String? = null,
): DatatypeRoot
