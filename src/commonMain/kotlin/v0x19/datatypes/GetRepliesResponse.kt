package v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class GetRepliesResponse(
    val replies: List<CommentReplyView>,
)
