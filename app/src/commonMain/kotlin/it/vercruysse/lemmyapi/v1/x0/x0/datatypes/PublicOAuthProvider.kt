package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class PublicOAuthProvider(
    val id: OAuthProviderId,
    val display_name: String,
    val authorization_endpoint: String,
    val client_id: String,
    val scopes: String,
    val use_pkce: Boolean,
)
