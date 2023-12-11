package it.vercruysse.lemmyapi.v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class UpdateTotp(
    val totp_token: String,
    val enabled: Boolean,
)
