package v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class PrivateMessageView(
    val private_message: PrivateMessage,
    val creator: Person,
    val recipient: Person,
)
