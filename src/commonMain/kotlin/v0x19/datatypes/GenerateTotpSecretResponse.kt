package v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class GenerateTotpSecretResponse(
    val totp_secret_url: String,
)
