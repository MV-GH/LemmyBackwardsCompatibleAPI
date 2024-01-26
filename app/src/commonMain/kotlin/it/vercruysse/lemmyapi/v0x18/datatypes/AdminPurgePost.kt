package it.vercruysse.lemmyapi.v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class AdminPurgePost(
    val id: Long,
    val admin_person_id: PersonId,
    val community_id: CommunityId,
    val reason: String? = null,
    val when_: String,
)
