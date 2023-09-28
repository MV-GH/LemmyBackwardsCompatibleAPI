package v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class EditComment(
    val comment_id: CommentId,
    val content: String? = null,
    val language_id: LanguageId? = null,
    val form_id: String? = null,
    val auth: String,
)
