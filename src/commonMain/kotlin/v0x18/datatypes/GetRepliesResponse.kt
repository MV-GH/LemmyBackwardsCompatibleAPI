package v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class GetRepliesResponse(
    val replies: List<CommentReplyView>,
)
