package v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class RemoveComment(
    val comment_id: CommentId,
    val removed: Boolean,
    val reason: String? = null,
)
