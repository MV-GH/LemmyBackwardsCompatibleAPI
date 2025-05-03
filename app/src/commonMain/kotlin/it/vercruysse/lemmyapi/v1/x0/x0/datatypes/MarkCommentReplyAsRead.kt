package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class MarkCommentReplyAsRead(
    val comment_reply_id: CommentReplyId,
    val read: Boolean,
)
