package v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class CreatePostReport(
    val post_id: PostId,
    val reason: String,
    val auth: String,
)
