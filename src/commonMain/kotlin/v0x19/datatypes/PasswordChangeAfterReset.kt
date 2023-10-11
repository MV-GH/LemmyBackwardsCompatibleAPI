package v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class PasswordChangeAfterReset(
    val token: String,
    val password: String,
    val password_verify: String,
)
