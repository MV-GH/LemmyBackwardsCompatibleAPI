package it.vercruysse.lemmyapi.v0x19x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class InstanceWithFederationState(
    val id: InstanceId,
    val domain: String,
    val published: String,
    val updated: String? = null,
    val software: String? = null,
    val version: String? = null,
    val federation_state: ReadableFederationState? = null,
)
