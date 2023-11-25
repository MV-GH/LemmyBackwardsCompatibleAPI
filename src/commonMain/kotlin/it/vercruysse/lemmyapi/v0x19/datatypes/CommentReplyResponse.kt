package it.vercruysse.lemmyapi.v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class CommentReplyResponse(
    val comment_reply_view: CommentReplyView,
)
