package v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class PrivateMessagesResponse(
    val private_messages: List<PrivateMessageView>,
)
