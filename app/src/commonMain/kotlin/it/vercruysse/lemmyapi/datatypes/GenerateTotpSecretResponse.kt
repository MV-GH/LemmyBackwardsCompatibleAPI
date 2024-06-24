package it.vercruysse.lemmyapi.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class GenerateTotpSecretResponse(
    val totp_secret_url: String,
)
