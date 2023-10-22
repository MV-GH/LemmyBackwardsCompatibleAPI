package v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class MarkPostAsRead(
//    val post_id: PostId? = null, // Removed because it will be deprecated in the next version anyway, just use the list argument
    val post_ids: List<PostId>,
    val read: Boolean,
)
