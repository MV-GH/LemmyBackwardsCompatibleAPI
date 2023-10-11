package v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class CommentResponse(
    val comment_view: CommentView,
    val recipient_ids: List<LocalUserId>,
)
