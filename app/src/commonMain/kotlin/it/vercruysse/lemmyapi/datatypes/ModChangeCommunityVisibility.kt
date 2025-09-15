package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.dto.CommunityVisibility
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class ModChangeCommunityVisibility(
    val id: Long,
    val community_id: CommunityId,
    val mod_person_id: PersonId,
    val published_at: String,
    /** Removed in 1.0.0 */
    val reason: String? = null,
    val visibility: CommunityVisibility /* "Public" | "Unlisted" | "LocalOnlyPublic" | "LocalOnlyPrivate" | "Private" */,
): DatatypeRoot
