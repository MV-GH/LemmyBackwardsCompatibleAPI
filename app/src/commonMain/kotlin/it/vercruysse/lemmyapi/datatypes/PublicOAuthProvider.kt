package it.vercruysse.lemmyapi.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class PublicOAuthProvider(
    val id: OAuthProviderId,
    val display_name: String,
    val authorization_endpoint: String,
    val client_id: String,
    val scopes: String,
    val use_pkce: Boolean,
)
