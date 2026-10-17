package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class PublicOAuthProvider(
    val id: OAuthProviderId,
    val display_name: String,
    val authorization_endpoint: String,
    val client_id: String,
    val scopes: String,
    val use_pkce: Boolean,
) : DatatypeRoot
