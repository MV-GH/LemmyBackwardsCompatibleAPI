package v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class VerifyEmail(
    val token: String,
)
