package it.vercruysse.lemmyapi.v0.x18.x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class Login(
    val username_or_email: String,
    val password: String,
    val totp_2fa_token: String? = null,
)
