package v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class DeletePrivateMessage(
    val private_message_id: PrivateMessageId,
    val deleted: Boolean,
    val auth: String,
)
