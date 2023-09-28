package v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class DeleteAccount(
    val password: String,
    val auth: String,
)
