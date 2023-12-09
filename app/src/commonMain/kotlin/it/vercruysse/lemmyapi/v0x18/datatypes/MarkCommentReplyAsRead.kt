package it.vercruysse.lemmyapi.v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class MarkCommentReplyAsRead(
    val comment_reply_id: CommentReplyId,
    val read: Boolean,
    val auth: String,
)
