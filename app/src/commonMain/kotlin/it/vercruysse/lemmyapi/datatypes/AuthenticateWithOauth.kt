package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class AuthenticateWithOauth(
    val code: String,
    val oauth_provider_id: OAuthProviderId,
    val redirect_uri: String,
    val show_nsfw: Boolean? = null,
    val username: String? = null,
    val answer: String? = null,
    val pkce_code_verifier: String? = null,
): DatatypeRoot
