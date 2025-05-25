package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

// TODO: followState enum

@CommonParcelize
@Serializable
data class PendingFollow(
    val person: Person,
    val community: Community,
    val is_new_instance: Boolean,
    val follow_state: String? /* "Accepted" | "Pending" | "ApprovalRequired" */ = null,
): DatatypeRoot
