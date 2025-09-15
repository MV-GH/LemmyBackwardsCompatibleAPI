package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.dto.CommunityFollowerState
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class MultiCommunityFollow(
    val multi_community_id: MultiCommunityId,
    val person_id: PersonId,
    val follow_state: CommunityFollowerState /* "Accepted" | "Pending" | "ApprovalRequired" */,
) : DatatypeRoot
