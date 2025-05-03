package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class FederationBlockList(
    val instance_id: InstanceId,
    val published: String,
    val updated: String? = null,
    val expires: String? = null,
)
