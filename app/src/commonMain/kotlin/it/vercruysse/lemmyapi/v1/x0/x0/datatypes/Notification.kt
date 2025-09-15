package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import it.vercruysse.lemmyapi.dto.NotificationType
import kotlinx.serialization.Serializable

@Serializable
internal data class Notification(
    val id: NotificationId,
    val recipient_id: PersonId,
    val comment_id: CommentId? = null,
    val read: Boolean,
    val published_at: String,
    val kind: NotificationType /* "Mention" | "Reply" | "Subscribed" | "PrivateMessage" */,
    val post_id: PostId? = null,
    val private_message_id: PrivateMessageId? = null,
)
