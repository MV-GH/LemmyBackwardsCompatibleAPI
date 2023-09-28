package v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class SaveComment(
    val comment_id: CommentId,
    val save: Boolean,
    val auth: String,
)
