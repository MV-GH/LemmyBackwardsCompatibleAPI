package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@Serializable
data class GenerateTotpSecretResponse(
    val totp_secret_url: String,
) : DatatypeRoot
