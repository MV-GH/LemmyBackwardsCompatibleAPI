package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import it.vercruysse.lemmyapi.dto.CommunityVisibility
import kotlinx.serialization.Serializable

@Serializable
internal data class ModChangeCommunityVisibility(
    val id: ModChangeCommunityVisibilityId,
    val community_id: CommunityId,
    val mod_person_id: PersonId,
    val published_at: String,
    val visibility: CommunityVisibility /* "Public" | "Unlisted" | "LocalOnlyPublic" | "LocalOnlyPrivate" | "Private" */,
)
