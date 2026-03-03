package it.vercruysse.lemmyapi.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class FederationAllowList(
    val published_at: String,
    val updated_at: String? = null,
)
