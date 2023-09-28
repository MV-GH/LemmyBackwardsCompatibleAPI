package v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class EditPrivateMessage(
    val private_message_id: PrivateMessageId,
    val content: String,
    val auth: String,
)
