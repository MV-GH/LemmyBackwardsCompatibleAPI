package v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class CreateCommentReport(
    val comment_id: CommentId,
    val reason: String,
    val auth: String,
)
