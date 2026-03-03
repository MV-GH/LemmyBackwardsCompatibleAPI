package it.vercruysse.lemmyapi.enums

import io.github.z4kn4fein.semver.Version
import it.vercruysse.lemmyapi.MINIMUM_API_VERSION
import it.vercruysse.lemmyapi.V1_0_0
import kotlinx.serialization.Serializable

// TODO: changes
@Serializable
enum class ModlogActionType(override val minimumVersion: Version = MINIMUM_API_VERSION, override val maximumVersion: Version? = null) :
    VersionTracker {
    All,
    ModRemovePost,
    ModLockPost,
    ModFeaturePost,
    ModRemoveComment,
    ModLockComment(V1_0_0),

    /** Deprecated alias for AdminRemoveCommunity */
    ModRemoveCommunity(MINIMUM_API_VERSION, V1_0_0),
    AdminRemoveCommunity(V1_0_0),
    ModBanFromCommunity,

    /** Deprecated alias for ModAddToCommunity */
    ModAddCommunity(MINIMUM_API_VERSION, V1_0_0),
    ModAddToCommunity(V1_0_0),
    ModTransferCommunity,

    /** Deprecated alias for AdminAdd */
    ModAdd(MINIMUM_API_VERSION, V1_0_0),

    /** Deprecated alias for AdminBan */
    ModBan(MINIMUM_API_VERSION, V1_0_0),
    AdminAdd(V1_0_0),
    AdminBan(V1_0_0),
    ModHideCommunity(MINIMUM_API_VERSION, V1_0_0),
    ModChangeCommunityVisibility(V1_0_0),
    AdminPurgePerson,
    AdminPurgeCommunity,
    AdminPurgePost,
    AdminPurgeComment,
    AdminBlockInstance(V1_0_0),
    AdminAllowInstance(V1_0_0),
}
