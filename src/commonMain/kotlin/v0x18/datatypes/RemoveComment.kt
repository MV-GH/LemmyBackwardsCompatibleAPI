package v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class RemoveComment(
    val comment_id: CommentId,
    val removed: Boolean,
    val reason: String? = null,
    val auth: String,
)
