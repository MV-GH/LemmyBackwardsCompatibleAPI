package v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class PrivateMessageResponse(
    val private_message_view: PrivateMessageView,
)
