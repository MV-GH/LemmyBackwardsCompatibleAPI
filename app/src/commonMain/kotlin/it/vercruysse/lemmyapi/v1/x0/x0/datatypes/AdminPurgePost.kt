package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class AdminPurgePost(
    val id: AdminPurgePostId,
    val admin_person_id: PersonId,
    val community_id: CommunityId,
    val reason: String? = null,
    val published: String,
)
