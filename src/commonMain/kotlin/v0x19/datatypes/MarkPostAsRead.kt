package v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class MarkPostAsRead(
    val post_id: PostId,
    val read: Boolean,
)
