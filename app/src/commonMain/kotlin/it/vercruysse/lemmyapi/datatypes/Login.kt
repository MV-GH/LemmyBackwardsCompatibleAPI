package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class Login(
    val username_or_email: SensitiveString,
    val password: SensitiveString,
    val totp_2fa_token: String? = null,
    val stay_logged_in: Boolean? = null,
) : DatatypeRoot
