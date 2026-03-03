package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.dto.ModlogActionType
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.dto.ListingType

@CommonParcelize
@Serializable
data class GetModlog(
    val mod_person_id: PersonId? = null,
    val community_id: CommunityId? = null,
    val type_: ModlogActionType? /* "All" | "ModRemovePost" | "ModLockPost" | "ModFeaturePost" | "ModRemoveComment" | "ModLockComment" | "AdminRemoveCommunity" | "ModBanFromCommunity" | "ModAddToCommunity" | "ModTransferCommunity" | "AdminAdd" | "AdminBan" | "ModChangeCommunityVisibility" | "AdminPurgePerson" | "AdminPurgeCommunity" | "AdminPurgePost" | "AdminPurgeComment" | "AdminBlockInstance" | "AdminAllowInstance" */ = null,
    /** Added in 1.0.0 */
    val listing_type: ListingType? /* "All" | "Local" | "Subscribed" | "ModeratorView" | "Suggested" */ = null,
    val other_person_id: PersonId? = null,
    val post_id: PostId? = null,
    val comment_id: CommentId? = null,
    /** Added in 1.0.0 */
    val page_cursor: PaginationCursor? = null,
    /** Removed in 1.0.0 */
    val page: Long? = null,
    val limit: Long? = null,
) : DatatypeRoot
