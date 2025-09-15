package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.dto.CommunityFollowerState
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class PendingFollow(
    val person: Person,
    val community: Community,
    val is_new_instance: Boolean,
    val follow_state: CommunityFollowerState? /* "Accepted" | "Pending" | "ApprovalRequired" */ = null,
): DatatypeRoot
