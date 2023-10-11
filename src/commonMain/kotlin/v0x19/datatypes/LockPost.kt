package v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class LockPost(
    val post_id: PostId,
    val locked: Boolean,
)
