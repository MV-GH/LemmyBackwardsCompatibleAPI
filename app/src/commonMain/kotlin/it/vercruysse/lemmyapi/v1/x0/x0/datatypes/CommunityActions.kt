package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import it.vercruysse.lemmyapi.dto.CommunityFollowerState
import it.vercruysse.lemmyapi.dto.CommunityNotificationsMode
import kotlinx.serialization.Serializable

@Serializable
internal data class CommunityActions(
    val followed_at: String? = null,
    val blocked_at: String? = null,
    val became_moderator_at: String? = null,
    val received_ban_at: String? = null,
    val ban_expires_at: String? = null,
    val follow_state: CommunityFollowerState? /* "accepted" | "pending" | "approval_required" | "denied" */ = null,
    val notifications: CommunityNotificationsMode? /* "all_posts_and_comments" | "all_posts" | "replies_and_mentions" | "mute" */ = null,
)
