package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class CommentResponse(
    val comment_view: CommentView,
    val recipient_ids: List<LocalUserId>,
)
