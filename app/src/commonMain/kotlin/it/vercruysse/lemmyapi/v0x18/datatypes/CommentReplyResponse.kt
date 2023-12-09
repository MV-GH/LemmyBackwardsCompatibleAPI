package it.vercruysse.lemmyapi.v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class CommentReplyResponse(
    val comment_reply_view: CommentReplyView,
)
