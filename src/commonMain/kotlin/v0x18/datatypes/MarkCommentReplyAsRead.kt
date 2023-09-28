package v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class MarkCommentReplyAsRead(
    val comment_reply_id: CommentReplyId,
    val read: Boolean,
    val auth: String,
)
