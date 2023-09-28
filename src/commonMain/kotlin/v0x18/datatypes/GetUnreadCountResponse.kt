package v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class GetUnreadCountResponse(
    val replies: Int,
    val mentions: Int,
    val private_messages: Int,
)
