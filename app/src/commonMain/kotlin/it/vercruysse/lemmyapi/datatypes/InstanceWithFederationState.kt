package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

@CommonParcelize
@Serializable
data class InstanceWithFederationState(
    val id: InstanceId,
    val domain: String,
    val published_at: String,
    val updated_at: String? = null,
    val software: String? = null,
    val version: String? = null,
    val federation_state: FederationQueueState? = null,
) : DatatypeRoot
