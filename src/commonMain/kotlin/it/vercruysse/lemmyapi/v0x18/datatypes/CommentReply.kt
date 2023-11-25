package it.vercruysse.lemmyapi.v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class CommentReply(
    val id: CommentReplyId,
    val recipient_id: PersonId,
    val comment_id: CommentId,
    val read: Boolean,
    val published: String,
)
