package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import it.vercruysse.lemmyapi.dto.CommunityFollowerState
import it.vercruysse.lemmyapi.dto.CommunityNotificationsMode
import kotlinx.serialization.Serializable

@Serializable
internal data class CommunityActions(
    val followed_at: String? = null,
    val follow_state: CommunityFollowerState? /* "Accepted" | "Pending" | "ApprovalRequired" */ = null,
    val blocked_at: String? = null,
    val became_moderator_at: String? = null,
    val received_ban_at: String? = null,
    val ban_expires_at: String? = null,
    val notifications: CommunityNotificationsMode? /* "AllPostsAndComments" | "AllPosts" | "RepliesAndMentions" | "Mute" */ = null,
)
