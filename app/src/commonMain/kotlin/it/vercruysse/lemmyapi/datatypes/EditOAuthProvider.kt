package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
internal data class EditOAuthProvider(
    val id: OAuthProviderId,
    val display_name: String? = null,
    val authorization_endpoint: String? = null,
    val token_endpoint: String? = null,
    val userinfo_endpoint: String? = null,
    val id_claim: String? = null,
    val client_secret: String? = null,
    val scopes: String? = null,
    val auto_verify_email: Boolean? = null,
    val account_linking_enabled: Boolean? = null,
    val use_pkce: Boolean? = null,
    val enabled: Boolean? = null,
): DatatypeRoot
