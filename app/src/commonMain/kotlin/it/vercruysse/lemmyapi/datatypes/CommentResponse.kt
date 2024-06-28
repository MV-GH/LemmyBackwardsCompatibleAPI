package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@Serializable
data class CommentResponse(
    val comment_view: CommentView,
    val recipient_ids: List<LocalUserId>,
) : DatatypeRoot
