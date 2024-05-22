package it.vercruysse.lemmyapi.v0x19x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class CommentResponse(
    val comment_view: CommentView,
    val recipient_ids: List<LocalUserId>,
)
