package it.vercruysse.lemmyapi.v0.x18.x5.datatypes

import it.vercruysse.lemmyapi.dto.ModlogActionType
import kotlinx.serialization.Serializable

@Serializable
internal data class GetModlog(
    val mod_person_id: PersonId? = null,
    val community_id: CommunityId? = null,
    val page: Long? = null,
    val limit: Long? = null,
    val type_: ModlogActionType? /* "All" | "ModRemovePost" | "ModLockPost" | "ModFeaturePost" | "ModRemoveComment" | "ModRemoveCommunity" | "ModBanFromCommunity" | "ModAddCommunity" | "ModTransferCommunity" | "ModAdd" | "ModBan" | "ModHideCommunity" | "AdminPurgePerson" | "AdminPurgeCommunity" | "AdminPurgePost" | "AdminPurgeComment" */ = null,
    val other_person_id: PersonId? = null,
    val auth: String? = null,
)
