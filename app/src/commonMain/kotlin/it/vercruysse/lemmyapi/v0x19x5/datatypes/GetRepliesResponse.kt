package it.vercruysse.lemmyapi.v0x19x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class GetRepliesResponse(
    val replies: List<CommentReplyView>,
)
