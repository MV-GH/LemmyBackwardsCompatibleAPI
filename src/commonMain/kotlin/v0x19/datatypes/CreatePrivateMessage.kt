package v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class CreatePrivateMessage(
    val content: String,
    val recipient_id: PersonId,
)
