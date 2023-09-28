package v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class PasswordReset(
    val email: String,
)
