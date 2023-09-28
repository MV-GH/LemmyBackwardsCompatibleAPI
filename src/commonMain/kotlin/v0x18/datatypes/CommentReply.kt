package v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class CommentReply(
    val id: CommentReplyId,
    val recipient_id: PersonId,
    val comment_id: CommentId,
    val read: Boolean,
    val published: String,
)
