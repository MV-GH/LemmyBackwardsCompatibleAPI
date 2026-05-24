package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class ChangePasswordAfterReset(
    val token: SensitiveString,
    val password: SensitiveString,
    val password_verify: SensitiveString,
)
