package v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class DeleteComment(
    val comment_id: CommentId,
    val deleted: Boolean,
    val auth: String,
)
