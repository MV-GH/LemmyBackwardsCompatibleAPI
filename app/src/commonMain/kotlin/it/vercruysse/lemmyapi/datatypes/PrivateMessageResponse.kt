package it.vercruysse.lemmyapi.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class PrivateMessageResponse(
    val private_message_view: PrivateMessageView,
)
