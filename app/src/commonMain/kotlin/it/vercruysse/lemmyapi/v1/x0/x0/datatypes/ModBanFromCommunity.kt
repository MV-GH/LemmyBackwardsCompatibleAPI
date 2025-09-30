package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class ModBanFromCommunity(
    val id: ModBanFromCommunityId,
    val mod_person_id: PersonId,
    val other_person_id: PersonId,
    val community_id: CommunityId,
    val reason: String,
    val banned: Boolean,
    val expires_at: String? = null,
    val published_at: String,
)
