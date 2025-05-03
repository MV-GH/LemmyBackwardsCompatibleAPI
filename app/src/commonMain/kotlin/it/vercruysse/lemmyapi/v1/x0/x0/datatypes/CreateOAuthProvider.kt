package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class CreateOAuthProvider(
    val display_name: String,
    val issuer: String,
    val authorization_endpoint: String,
    val token_endpoint: String,
    val userinfo_endpoint: String,
    val id_claim: String,
    val client_id: String,
    val client_secret: String,
    val scopes: String,
    val auto_verify_email: Boolean? = null,
    val account_linking_enabled: Boolean? = null,
    val use_pkce: Boolean? = null,
    val enabled: Boolean? = null,
)
