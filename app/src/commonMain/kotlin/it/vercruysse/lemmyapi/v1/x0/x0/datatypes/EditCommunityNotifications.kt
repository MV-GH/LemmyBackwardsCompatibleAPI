package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import it.vercruysse.lemmyapi.enums.CommunityNotificationsMode
import kotlinx.serialization.Serializable

@Serializable
internal data class EditCommunityNotifications(
    val community_id: CommunityId,
    val mode: CommunityNotificationsMode /* "all_posts_and_comments" | "all_posts" | "replies_and_mentions" | "mute" */,
)
