package it.vercruysse.lemmyapi.enums

import io.github.z4kn4fein.semver.Version
import it.vercruysse.lemmyapi.MINIMUM_API_VERSION
import it.vercruysse.lemmyapi.V1_0_0
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class ModlogActionType(override val minimumVersion: Version = MINIMUM_API_VERSION, override val maximumVersion: Version? = null) :
    VersionTracker {
    @SerialName("all")
    All,

    @SerialName("mod_remove_post")
    ModRemovePost,

    @SerialName("mod_lock_post")
    ModLockPost,

    @SerialName("mod_feature_post")
    ModFeaturePost,

    @SerialName("mod_remove_comment")
    ModRemoveComment,

    @SerialName("mod_lock_comment")
    ModLockComment(V1_0_0),

    @SerialName("admin_remove_community")
    AdminRemoveCommunity(MINIMUM_API_VERSION),

    @SerialName("mod_ban_from_community")
    ModBanFromCommunity,

    @SerialName("mod_add_to_community")
    ModAddToCommunity(MINIMUM_API_VERSION),

    @SerialName("mod_transfer_community")
    ModTransferCommunity,

    @SerialName("admin_add")
    AdminAdd(MINIMUM_API_VERSION),

    @SerialName("admin_ban")
    AdminBan(MINIMUM_API_VERSION),

    @SerialName("mod_change_community_visibility")
    ModChangeCommunityVisibility(MINIMUM_API_VERSION),

    @SerialName("admin_purge_person")
    AdminPurgePerson,

    @SerialName("admin_purge_community")
    AdminPurgeCommunity,

    @SerialName("admin_purge_post")
    AdminPurgePost,

    @SerialName("admin_purge_comment")
    AdminPurgeComment,

    @SerialName("admin_block_instance")
    AdminBlockInstance(V1_0_0),

    @SerialName("admin_allow_instance")
    AdminAllowInstance(V1_0_0),

    @SerialName("mod_warn_comment")
    ModWarnComment(V1_0_0),

    @SerialName("mod_warn_post")
    ModWarnPost(V1_0_0),

    @SerialName("admin_feature_post_site")
    AdminFeaturePostSite(V1_0_0),
}
