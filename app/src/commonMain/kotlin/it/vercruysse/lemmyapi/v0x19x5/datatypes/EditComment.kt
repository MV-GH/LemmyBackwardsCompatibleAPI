package it.vercruysse.lemmyapi.v0x19x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class EditComment(
    val comment_id: CommentId,
    val content: String? = null,
    val language_id: LanguageId? = null,
)
