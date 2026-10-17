package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import it.vercruysse.lemmyapi.enums.PostNotificationsMode
import kotlinx.serialization.Serializable

@Serializable
internal data class EditPostNotifications(
    val post_id: PostId,
    val mode: PostNotificationsMode /* "all_comments" | "replies_and_mentions" | "mute" */,
)
