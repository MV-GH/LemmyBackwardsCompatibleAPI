package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import it.vercruysse.lemmyapi.enums.CommunityFollowerState
import kotlinx.serialization.Serializable

@Serializable
internal data class MultiCommunityView(
    val multi: MultiCommunity,
    val follow_state: CommunityFollowerState? /* "accepted" | "pending" | "approval_required" | "denied" */ = null,
    val owner: Person,
)
