package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.dto.ModlogActionType
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

// TODO: many changes

@CommonParcelize
@Serializable
data class GetModlog(
    val mod_person_id: PersonId? = null,
    val community_id: CommunityId? = null,
    val page: Long? = null,
    val limit: Long? = null,
    val type_: ModlogActionType? /* "All" | "ModRemovePost" | "ModLockPost" | "ModFeaturePost" | "ModRemoveComment" | "ModRemoveCommunity" | "ModBanFromCommunity" | "ModAddCommunity" | "ModTransferCommunity" | "ModAdd" | "ModBan" | "ModHideCommunity" | "AdminPurgePerson" | "AdminPurgeCommunity" | "AdminPurgePost" | "AdminPurgeComment" */ = null,
    val other_person_id: PersonId? = null,
    val post_id: PostId? = null,
    val comment_id: CommentId? = null,
) : DatatypeRoot
