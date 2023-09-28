package v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class MarkPostAsRead(
    val post_id: PostId,
    val read: Boolean,
    val auth: String,
)
