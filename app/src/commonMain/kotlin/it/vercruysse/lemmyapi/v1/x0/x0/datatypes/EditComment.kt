package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class EditComment(
    val comment_id: CommentId,
    val content: String? = null,
    val language_id: LanguageId? = null,
)
