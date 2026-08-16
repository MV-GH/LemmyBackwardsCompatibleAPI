package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class EditComment(
    val comment_id: CommentId,
    val content: String? = null,
    val language_id: LanguageId? = null,
) : DatatypeRoot
