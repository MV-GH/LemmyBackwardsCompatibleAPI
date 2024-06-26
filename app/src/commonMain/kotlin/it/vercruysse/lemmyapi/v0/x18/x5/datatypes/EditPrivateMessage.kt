package it.vercruysse.lemmyapi.v0.x18.x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class EditPrivateMessage(
    val private_message_id: PrivateMessageId,
    val content: String,
    val auth: String,
)
