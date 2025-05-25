package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import it.vercruysse.lemmyapi.dto.CommunityVisibility
import kotlinx.serialization.Serializable

@Serializable
internal data class ModChangeCommunityVisibility(
    val id: Long,
    val community_id: CommunityId,
    val mod_person_id: PersonId,
    val published: String,
    val reason: String? = null,
    val visibility: CommunityVisibility /* "Public" | "Unlisted" | "LocalOnlyPublic" | "LocalOnlyPrivate" | "Private" */,
)
