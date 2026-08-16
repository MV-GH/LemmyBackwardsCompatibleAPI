package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class LoginResponse(
    val jwt: SensitiveString? = null,
    val registration_created: Boolean,
    val verify_email_sent: Boolean,
)
