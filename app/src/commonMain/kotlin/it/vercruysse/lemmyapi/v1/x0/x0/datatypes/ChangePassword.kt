package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class ChangePassword(
    val new_password: SensitiveString,
    val new_password_verify: SensitiveString,
    val old_password: SensitiveString,
)
