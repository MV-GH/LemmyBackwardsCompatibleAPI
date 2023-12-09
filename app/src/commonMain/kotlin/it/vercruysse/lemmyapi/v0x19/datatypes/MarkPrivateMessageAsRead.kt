package it.vercruysse.lemmyapi.v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class MarkPrivateMessageAsRead(
    val private_message_id: PrivateMessageId,
    val read: Boolean,
)
