package v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class PrivateMessagesResponse(
    val private_messages: List<PrivateMessageView>,
)
