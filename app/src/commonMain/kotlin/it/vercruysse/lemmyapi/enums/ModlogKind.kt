package it.vercruysse.lemmyapi.enums

import io.github.z4kn4fein.semver.Version
import it.vercruysse.lemmyapi.V1_0_0
import it.vercruysse.lemmyapi.enums.VersionTracker
import kotlinx.serialization.Serializable


@Serializable
enum class ModlogKind(override val minimumVersion: Version = V1_0_0, override val maximumVersion: Version? = null) : VersionTracker {
    All,
    AdminAdd,
    AdminBan,
    AdminAllowInstance,
    AdminBlockInstance,
    AdminPurgeComment,
    AdminPurgeCommunity,
    AdminPurgePerson,
    AdminPurgePost,
    ModAddToCommunity,
    ModBanFromCommunity,
    AdminFeaturePostSite,
    ModFeaturePostCommunity,
    ModChangeCommunityVisibility,
    ModLockPost,
    ModRemoveComment,
    AdminRemoveCommunity,
    ModRemovePost,
    ModTransferCommunity,
    ModLockComment,
    ModWarnComment,
    ModWarnPost,
}
