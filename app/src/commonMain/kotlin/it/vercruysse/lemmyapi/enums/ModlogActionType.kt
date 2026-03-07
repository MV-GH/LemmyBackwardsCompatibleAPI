package it.vercruysse.lemmyapi.enums

import io.github.z4kn4fein.semver.Version
import it.vercruysse.lemmyapi.MINIMUM_API_VERSION
import it.vercruysse.lemmyapi.V1_0_0
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// TODO: changes
@Serializable
enum class ModlogActionType(override val minimumVersion: Version = MINIMUM_API_VERSION, override val maximumVersion: Version? = null) :
    VersionTracker {
    @SerialName("all") All,
    @SerialName("mod_remove_post") ModRemovePost,
    @SerialName("mod_lock_post") ModLockPost,
    @SerialName("mod_feature_post") ModFeaturePost,
    @SerialName("mod_remove_comment") ModRemoveComment,
    @SerialName("mod_lock_comment") ModLockComment(V1_0_0),

    /** Deprecated alias for AdminRemoveCommunity */
    @SerialName("mod_remove_community") ModRemoveCommunity(MINIMUM_API_VERSION, V1_0_0),
    @SerialName("admin_remove_community") AdminRemoveCommunity(V1_0_0),
    @SerialName("mod_ban_from_community") ModBanFromCommunity,

    /** Deprecated alias for ModAddToCommunity */
    @SerialName("mod_add_community") ModAddCommunity(MINIMUM_API_VERSION, V1_0_0),
    @SerialName("mod_add_to_community") ModAddToCommunity(V1_0_0),
    @SerialName("mod_transfer_community") ModTransferCommunity,

    /** Deprecated alias for AdminAdd */
    @SerialName("mod_add") ModAdd(MINIMUM_API_VERSION, V1_0_0),

    /** Deprecated alias for AdminBan */
    @SerialName("mod_ban") ModBan(MINIMUM_API_VERSION, V1_0_0),
    @SerialName("admin_add") AdminAdd(V1_0_0),
    @SerialName("admin_ban") AdminBan(V1_0_0),
    @SerialName("mod_hide_community") ModHideCommunity(MINIMUM_API_VERSION, V1_0_0),
    @SerialName("mod_change_community_visibility") ModChangeCommunityVisibility(V1_0_0),
    @SerialName("admin_purge_person") AdminPurgePerson,
    @SerialName("admin_purge_community") AdminPurgeCommunity,
    @SerialName("admin_purge_post") AdminPurgePost,
    @SerialName("admin_purge_comment") AdminPurgeComment,
    @SerialName("admin_block_instance") AdminBlockInstance(V1_0_0),
    @SerialName("admin_allow_instance") AdminAllowInstance(V1_0_0),
}
