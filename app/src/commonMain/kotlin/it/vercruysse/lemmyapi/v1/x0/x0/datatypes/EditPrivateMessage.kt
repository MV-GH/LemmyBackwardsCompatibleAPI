package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class EditPrivateMessage(
    val private_message_id: PrivateMessageId,
    val content: String,
)
