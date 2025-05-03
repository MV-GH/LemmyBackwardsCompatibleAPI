package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class AuthenticateWithOauth(
    val code: String,
    val oauth_provider_id: OAuthProviderId,
    val redirect_uri: String,
    val show_nsfw: Boolean? = null,
    val username: String? = null,
    val answer: String? = null,
    val pkce_code_verifier: String? = null,
)
