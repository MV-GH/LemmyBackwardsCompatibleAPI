package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class OAuthProvider(
    val id: OAuthProviderId,
    val display_name: String,
    val issuer: String,
    val authorization_endpoint: String,
    val token_endpoint: String,
    val userinfo_endpoint: String,
    val id_claim: String,
    val client_id: String,
    val scopes: String,
    val auto_verify_email: Boolean,
    val account_linking_enabled: Boolean,
    val enabled: Boolean,
    val published: String,
    val updated: String? = null,
    val use_pkce: Boolean,
)
