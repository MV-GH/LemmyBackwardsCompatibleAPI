package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@Serializable
data class UpdateTotp(
    val totp_token: String,
    val enabled: Boolean,
) : DatatypeRoot
