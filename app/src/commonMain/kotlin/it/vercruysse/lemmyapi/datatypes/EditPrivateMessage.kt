package it.vercruysse.lemmyapi.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class EditPrivateMessage(
    val private_message_id: PrivateMessageId,
    val content: String,
)