package it.vercruysse.lemmyapi.v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class GetUnreadCountResponse(
    val replies: Long,
    val mentions: Long,
    val private_messages: Long,
)
