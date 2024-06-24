package it.vercruysse.lemmyapi.v0.x18.x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class LoginResponse(
    val jwt: String? = null,
    val registration_created: Boolean,
    val verify_email_sent: Boolean,
)
