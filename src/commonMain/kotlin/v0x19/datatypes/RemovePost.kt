package v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class RemovePost(
    val post_id: PostId,
    val removed: Boolean,
    val reason: String? = null,
)
