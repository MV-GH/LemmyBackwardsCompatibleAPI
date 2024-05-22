package it.vercruysse.lemmyapi.v0x19x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class CommentReplyResponse(
    val comment_reply_view: CommentReplyView,
)
