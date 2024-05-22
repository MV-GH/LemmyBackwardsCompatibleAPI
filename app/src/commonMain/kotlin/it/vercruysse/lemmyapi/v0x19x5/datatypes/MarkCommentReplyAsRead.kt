package it.vercruysse.lemmyapi.v0x19x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class MarkCommentReplyAsRead(
    val comment_reply_id: CommentReplyId,
    val read: Boolean,
)
