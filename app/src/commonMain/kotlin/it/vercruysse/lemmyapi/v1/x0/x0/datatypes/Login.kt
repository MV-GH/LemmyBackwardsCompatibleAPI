package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class Login(
    val username_or_email: SensitiveString,
    val password: SensitiveString,
    val totp_2fa_token: String? = null,
)
