package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@Serializable
data class CommentReplyResponse(
    val comment_reply_view: CommentReplyView,
) : DatatypeRoot
