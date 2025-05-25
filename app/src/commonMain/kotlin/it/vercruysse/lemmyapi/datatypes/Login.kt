package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

@CommonParcelize
@Serializable
data class Login(
    val username_or_email: SensitiveString,
    val password: SensitiveString,
    val totp_2fa_token: String? = null,
) : DatatypeRoot
