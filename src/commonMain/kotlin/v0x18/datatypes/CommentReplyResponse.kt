package v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class CommentReplyResponse(
    val comment_reply_view: CommentReplyView,
)
