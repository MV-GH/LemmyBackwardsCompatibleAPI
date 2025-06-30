package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class CommunityActions(
    val followed: String? = null,
    val follow_state: String? /* "Accepted" | "Pending" | "ApprovalRequired" */ = null,
    val blocked: String? = null,
    val became_moderator: String? = null,
    val received_ban: String? = null,
    val ban_expires: String? = null,
)
