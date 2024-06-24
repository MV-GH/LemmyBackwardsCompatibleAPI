package it.vercruysse.lemmyapi.v0.x19.x4.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class PrivateMessageResponse(
    val private_message_view: PrivateMessageView,
)
