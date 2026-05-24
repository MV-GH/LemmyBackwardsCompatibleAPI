package it.vercruysse.lemmyapi.enums

import io.github.z4kn4fein.semver.Version
import it.vercruysse.lemmyapi.V1_0_0
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class ModlogKind(override val minimumVersion: Version = V1_0_0, override val maximumVersion: Version? = null) : VersionTracker {
    @SerialName("all")
    All,

    @SerialName("admin_add")
    AdminAdd,

    @SerialName("admin_ban")
    AdminBan,

    @SerialName("admin_allow_instance")
    AdminAllowInstance,

    @SerialName("admin_block_instance")
    AdminBlockInstance,

    @SerialName("admin_purge_comment")
    AdminPurgeComment,

    @SerialName("admin_purge_community")
    AdminPurgeCommunity,

    @SerialName("admin_purge_person")
    AdminPurgePerson,

    @SerialName("admin_purge_post")
    AdminPurgePost,

    @SerialName("mod_add_to_community")
    ModAddToCommunity,

    @SerialName("mod_ban_from_community")
    ModBanFromCommunity,

    @SerialName("admin_feature_post_site")
    AdminFeaturePostSite,

    @SerialName("mod_feature_post_community")
    ModFeaturePostCommunity,

    @SerialName("mod_change_community_visibility")
    ModChangeCommunityVisibility,

    @SerialName("mod_lock_post")
    ModLockPost,

    @SerialName("mod_remove_comment")
    ModRemoveComment,

    @SerialName("admin_remove_community")
    AdminRemoveCommunity,

    @SerialName("mod_remove_post")
    ModRemovePost,

    @SerialName("mod_transfer_community")
    ModTransferCommunity,

    @SerialName("mod_lock_comment")
    ModLockComment,

    @SerialName("mod_warn_comment")
    ModWarnComment,

    @SerialName("mod_warn_post")
    ModWarnPost,
}
