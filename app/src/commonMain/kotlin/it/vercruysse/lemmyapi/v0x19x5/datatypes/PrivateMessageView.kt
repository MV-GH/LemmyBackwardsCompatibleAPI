package it.vercruysse.lemmyapi.v0x19x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class PrivateMessageView(
    val private_message: PrivateMessage,
    val creator: Person,
    val recipient: Person,
)
