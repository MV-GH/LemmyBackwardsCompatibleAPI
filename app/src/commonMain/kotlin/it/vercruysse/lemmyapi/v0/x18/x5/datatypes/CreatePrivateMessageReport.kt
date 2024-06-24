package it.vercruysse.lemmyapi.v0.x18.x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class CreatePrivateMessageReport(
    val private_message_id: PrivateMessageId,
    val reason: String,
    val auth: String,
)
