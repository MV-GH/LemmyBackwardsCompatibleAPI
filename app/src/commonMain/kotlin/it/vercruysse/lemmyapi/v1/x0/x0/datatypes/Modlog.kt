package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import it.vercruysse.lemmyapi.enums.ModlogKind
import kotlinx.serialization.Serializable

@Serializable
internal data class Modlog(
    val id: ModlogId,
    val kind: ModlogKind /* "admin_add" | "admin_ban" | "admin_allow_instance" | "admin_block_instance" | "admin_purge_comment" | "admin_purge_community" | "admin_purge_person" | "admin_purge_post" | "mod_add_to_community" | "mod_ban_from_community" | "admin_feature_post_site" | "mod_feature_post_community" | "mod_change_community_visibility" | "mod_lock_post" | "mod_remove_comment" | "admin_remove_community" | "mod_remove_post" | "mod_transfer_community" | "mod_lock_comment" | "mod_warn_comment" | "mod_warn_post" */,
    val is_revert: Boolean,
    val reason: String? = null,
    val expires_at: String? = null,
    val published_at: String,
    val bulk_action_parent_id: ModlogId? = null,
    val child_count: Long,
)
