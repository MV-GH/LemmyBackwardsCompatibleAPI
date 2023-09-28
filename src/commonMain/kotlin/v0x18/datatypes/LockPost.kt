package v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class LockPost(
    val post_id: PostId,
    val locked: Boolean,
    val auth: String,
)
