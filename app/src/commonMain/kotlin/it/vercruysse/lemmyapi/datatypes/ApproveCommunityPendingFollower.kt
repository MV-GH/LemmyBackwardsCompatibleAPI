package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
internal data class ApproveCommunityPendingFollower(
    val community_id: CommunityId,
    val follower_id: PersonId,
    val approve: Boolean,
): DatatypeRoot
