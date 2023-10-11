package v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class CreateCommentReport(
    val comment_id: CommentId,
    val reason: String,
)
