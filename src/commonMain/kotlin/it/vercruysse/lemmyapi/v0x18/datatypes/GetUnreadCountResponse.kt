package it.vercruysse.lemmyapi.v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class GetUnreadCountResponse(
    val replies: Int,
    val mentions: Int,
    val private_messages: Int,
)
