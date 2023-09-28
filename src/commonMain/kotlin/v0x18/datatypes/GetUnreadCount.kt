package v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class GetUnreadCount(
    val auth: String,
)
