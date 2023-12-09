package it.vercruysse.lemmyapi.v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class PrivateMessagesResponse(
    val private_messages: List<PrivateMessageView>,
)
