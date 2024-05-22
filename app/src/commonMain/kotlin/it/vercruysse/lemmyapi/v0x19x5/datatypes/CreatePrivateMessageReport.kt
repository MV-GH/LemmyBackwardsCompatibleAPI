package it.vercruysse.lemmyapi.v0x19x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class CreatePrivateMessageReport(
    val private_message_id: PrivateMessageId,
    val reason: String,
)
