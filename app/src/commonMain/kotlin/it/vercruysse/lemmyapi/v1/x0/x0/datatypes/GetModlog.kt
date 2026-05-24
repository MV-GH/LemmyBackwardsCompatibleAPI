package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import it.vercruysse.lemmyapi.enums.ListingType
import it.vercruysse.lemmyapi.enums.ModlogActionType
import kotlinx.serialization.Serializable

@Serializable
internal data class GetModlog(
    val mod_person_id: PersonId? = null,
    val community_id: CommunityId? = null,
    val type_: ModlogActionType? /* "all" | "admin_add" | "admin_ban" | "admin_allow_instance" | "admin_block_instance" | "admin_purge_comment" | "admin_purge_community" | "admin_purge_person" | "admin_purge_post" | "mod_add_to_community" | "mod_ban_from_community" | "admin_feature_post_site" | "mod_feature_post_community" | "mod_change_community_visibility" | "mod_lock_post" | "mod_remove_comment" | "admin_remove_community" | "mod_remove_post" | "mod_transfer_community" | "mod_lock_comment" | "mod_warn_comment" | "mod_warn_post" */ = null,
    val listing_type: ListingType? /* "all" | "local" | "subscribed" | "moderator_view" | "suggested" */ = null,
    val other_person_id: PersonId? = null,
    val post_id: PostId? = null,
    val comment_id: CommentId? = null,
    val show_bulk: Boolean? = null,
    val bulk_action_parent_id: ModlogId? = null,
    val page_cursor: PaginationCursor? = null,
    val limit: Long? = null,
)
