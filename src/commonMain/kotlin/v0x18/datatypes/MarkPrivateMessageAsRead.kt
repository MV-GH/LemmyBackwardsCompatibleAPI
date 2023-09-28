package v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class MarkPrivateMessageAsRead(
    val private_message_id: PrivateMessageId,
    val read: Boolean,
    val auth: String,
)
