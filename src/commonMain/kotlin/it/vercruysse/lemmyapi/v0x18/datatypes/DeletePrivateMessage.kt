package it.vercruysse.lemmyapi.v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class DeletePrivateMessage(
    val private_message_id: PrivateMessageId,
    val deleted: Boolean,
    val auth: String,
)
