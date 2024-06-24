package it.vercruysse.lemmyapi.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class GetRepliesResponse(
    val replies: List<CommentReplyView>,
)
