package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class CreatePrivateMessageReport(
    val private_message_id: PrivateMessageId,
    val reason: String,
)
