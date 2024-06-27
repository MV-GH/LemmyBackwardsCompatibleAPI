package it.vercruysse.lemmyapi.v0.x18.x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class PrivateMessagesResponse(
    val private_messages: List<PrivateMessageView>,
)
