package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

// TODO: Inbox endpoints merged

@CommonParcelize
@Serializable
data class CommentReplyResponse(
    val comment_reply_view: CommentReplyView,
) : DatatypeRoot
