package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.enums.CommunityFollowerState
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class MultiCommunityView(
    val multi: MultiCommunity,
    val follow_state: CommunityFollowerState? /* "accepted" | "pending" | "approval_required" | "denied" */ = null,
    val owner: Person,
) : DatatypeRoot
