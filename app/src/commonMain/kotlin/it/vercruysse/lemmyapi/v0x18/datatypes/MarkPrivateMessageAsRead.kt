package it.vercruysse.lemmyapi.v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class MarkPrivateMessageAsRead(
    val private_message_id: PrivateMessageId,
    val read: Boolean,
    val auth: String,
)
