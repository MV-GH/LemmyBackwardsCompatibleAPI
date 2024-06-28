package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@Serializable
data class Login(
    val username_or_email: String,
    val password: String,
    val totp_2fa_token: String? = null,
) : DatatypeRoot
