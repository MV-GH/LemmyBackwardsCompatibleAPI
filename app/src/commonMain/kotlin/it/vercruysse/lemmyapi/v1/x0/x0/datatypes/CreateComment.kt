package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class CreateComment(
    val content: String,
    val post_id: PostId,
    val parent_id: CommentId? = null,
    val language_id: LanguageId? = null,
)
