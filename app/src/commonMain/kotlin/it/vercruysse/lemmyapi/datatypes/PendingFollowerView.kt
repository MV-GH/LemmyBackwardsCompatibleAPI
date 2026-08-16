package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.enums.CommunityFollowerState
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class PendingFollowerView(
    val person: Person,
    val community: Community,
    val is_new_instance: Boolean,
    val follow_state: CommunityFollowerState? /* "accepted" | "pending" | "approval_required" | "denied" */ = null,
) : DatatypeRoot
