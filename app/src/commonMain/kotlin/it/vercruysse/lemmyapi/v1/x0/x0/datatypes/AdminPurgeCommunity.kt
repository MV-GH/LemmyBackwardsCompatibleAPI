package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class AdminPurgeCommunity(
    val id: AdminPurgeCommunityId,
    val admin_person_id: PersonId,
    val reason: String,
    val published_at: String,
)
