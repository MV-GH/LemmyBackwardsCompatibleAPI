package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@Serializable
data class CreateComment(
    val content: String,
    val post_id: PostId,
    val parent_id: CommentId? = null,
    val language_id: LanguageId? = null,
) : DatatypeRoot
