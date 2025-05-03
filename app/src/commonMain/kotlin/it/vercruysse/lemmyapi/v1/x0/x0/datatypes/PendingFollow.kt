package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class PendingFollow(
    val person: Person,
    val community: Community,
    val is_new_instance: Boolean,
    val follow_state: String? /* "Accepted" | "Pending" | "ApprovalRequired" */ = null,
)
