package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class CommunityActions(
    val community_id: CommunityId,
    val person_id: PersonId,
    val followed: String? = null,
    val follow_state: String? /* "Accepted" | "Pending" | "ApprovalRequired" */ = null,
    val follow_approver_id: PersonId? = null,
    val blocked: String? = null,
    val became_moderator: String? = null,
    val received_ban: String? = null,
    val ban_expires: String? = null,
): DatatypeRoot
