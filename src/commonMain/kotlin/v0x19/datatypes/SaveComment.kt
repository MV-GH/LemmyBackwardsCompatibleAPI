package v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class SaveComment(
    val comment_id: CommentId,
    val save: Boolean,
)
