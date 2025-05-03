package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class CommunityActions(
    val community_id: CommunityId,
    val person_id: PersonId,
    val followed: String? = null,
    val follow_state: String? /* "Accepted" | "Pending" | "ApprovalRequired" */ = null,
    val follow_approver_id: PersonId? = null,
    val blocked: String? = null,
    val became_moderator: String? = null,
    val received_ban: String? = null,
    val ban_expires: String? = null,
)
