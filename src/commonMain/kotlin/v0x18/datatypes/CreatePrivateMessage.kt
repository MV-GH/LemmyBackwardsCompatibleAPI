package v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class CreatePrivateMessage(
    val content: String,
    val recipient_id: PersonId,
    val auth: String,
)
