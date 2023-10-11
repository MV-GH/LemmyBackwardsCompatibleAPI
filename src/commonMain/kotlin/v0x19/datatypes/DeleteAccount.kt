package v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class DeleteAccount(
    val password: String,
    val delete_content: Boolean,
)
