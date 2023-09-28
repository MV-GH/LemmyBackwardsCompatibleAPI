package v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class SavePost(
    val post_id: PostId,
    val save: Boolean,
    val auth: String,
)
