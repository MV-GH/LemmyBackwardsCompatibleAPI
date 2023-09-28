package v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class PurgeComment(
    val comment_id: CommentId,
    val reason: String? = null,
    val auth: String,
)
