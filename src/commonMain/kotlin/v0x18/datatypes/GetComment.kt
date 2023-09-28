package v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class GetComment(
    val id: CommentId,
    val auth: String? = null,
)
