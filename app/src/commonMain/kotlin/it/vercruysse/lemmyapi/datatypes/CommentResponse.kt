package it.vercruysse.lemmyapi.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class CommentResponse(
    val comment_view: CommentView,
    val recipient_ids: List<LocalUserId>,
)
