package v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class LoginResponse(
    val jwt: String? = null,
    val registration_created: Boolean,
    val verify_email_sent: Boolean,
)
