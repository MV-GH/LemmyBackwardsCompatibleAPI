package it.vercruysse.lemmyapi.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class PrivateMessagesResponse(
    val private_messages: List<PrivateMessageView>,
)
