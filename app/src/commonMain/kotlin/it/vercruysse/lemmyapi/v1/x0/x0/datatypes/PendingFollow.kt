package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import it.vercruysse.lemmyapi.enums.CommunityFollowerState
import kotlinx.serialization.Serializable

@Serializable
internal data class PendingFollow(
    val person: Person,
    val community: Community,
    val is_new_instance: Boolean,
    val follow_state: CommunityFollowerState? /* "accepted" | "pending" | "approval_required" | "denied" */ = null,
)
