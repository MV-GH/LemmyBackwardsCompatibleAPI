package v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class DistinguishComment(
    val comment_id: CommentId,
    val distinguished: Boolean,
    val auth: String,
)
