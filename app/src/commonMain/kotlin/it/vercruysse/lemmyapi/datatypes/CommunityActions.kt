package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.dto.CommunityFollowerState
import it.vercruysse.lemmyapi.dto.CommunityNotificationsMode
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class CommunityActions(
    val followed_at: String? = null,
    val follow_state: CommunityFollowerState? /* "Accepted" | "Pending" | "ApprovalRequired" */ = null,
    val blocked_at: String? = null,
    val became_moderator_at: String? = null,
    val received_ban_at: String? = null,
    val ban_expires_at: String? = null,
    val notifications: CommunityNotificationsMode? /* "AllPostsAndComments" | "AllPosts" | "RepliesAndMentions" | "Mute" */ = null,
): DatatypeRoot
