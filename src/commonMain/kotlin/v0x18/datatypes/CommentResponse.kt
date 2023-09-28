package v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class CommentResponse(
    val comment_view: CommentView,
    val recipient_ids: List<LocalUserId>,
    val form_id: String? = null,
)
