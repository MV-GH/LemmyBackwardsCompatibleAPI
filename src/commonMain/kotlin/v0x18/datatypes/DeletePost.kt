package v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class DeletePost(
    val post_id: PostId,
    val deleted: Boolean,
    val auth: String,
)
