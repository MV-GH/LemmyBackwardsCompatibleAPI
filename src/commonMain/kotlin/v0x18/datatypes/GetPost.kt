package v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class GetPost(
    val id: PostId? = null,
    val comment_id: CommentId? = null,
    val auth: String? = null,
)
