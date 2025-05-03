package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class PrivateMessageView(
    val private_message: PrivateMessage,
    val creator: Person,
    val recipient: Person,
)
