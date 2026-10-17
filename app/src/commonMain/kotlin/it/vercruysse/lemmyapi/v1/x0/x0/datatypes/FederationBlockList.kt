package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class FederationBlockList(
    val published_at: String,
    val updated_at: String? = null,
    val expires_at: String? = null,
)
