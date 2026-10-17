package it.vercruysse.lemmyapi.v0.enums

import kotlinx.serialization.Serializable
import it.vercruysse.lemmyapi.enums.ModlogActionType as UniModlogActionType

@Serializable
internal enum class ModlogActionType {
    All,
    ModRemovePost,
    ModLockPost,
    ModFeaturePost,
    ModRemoveComment,
    ModRemoveCommunity,
    ModBanFromCommunity,
    ModAddCommunity,
    ModTransferCommunity,
    ModAdd,
    ModBan,
    ModHideCommunity,
    AdminPurgePerson,
    AdminPurgeCommunity,
    AdminPurgePost,
    AdminPurgeComment,
    ;

    fun toUni(): UniModlogActionType =
        when (this) {
            All -> UniModlogActionType.All
            ModRemovePost -> UniModlogActionType.ModRemovePost
            ModLockPost -> UniModlogActionType.ModLockPost
            ModFeaturePost -> UniModlogActionType.ModFeaturePost
            ModRemoveComment -> UniModlogActionType.ModRemoveComment
            ModRemoveCommunity -> UniModlogActionType.AdminRemoveCommunity
            ModBanFromCommunity -> UniModlogActionType.ModBanFromCommunity
            ModAddCommunity -> UniModlogActionType.ModAddToCommunity
            ModTransferCommunity -> UniModlogActionType.ModTransferCommunity
            ModAdd -> UniModlogActionType.AdminAdd
            ModBan -> UniModlogActionType.AdminBan
            ModHideCommunity -> UniModlogActionType.ModChangeCommunityVisibility
            AdminPurgePerson -> UniModlogActionType.AdminPurgePerson
            AdminPurgeCommunity -> UniModlogActionType.AdminPurgeCommunity
            AdminPurgePost -> UniModlogActionType.AdminPurgePost
            AdminPurgeComment -> UniModlogActionType.AdminPurgeComment
        }

    companion object {
        fun fromUniNullable(uni: UniModlogActionType?): ModlogActionType? =
            when (uni) {
                null -> null
                UniModlogActionType.All -> All
                UniModlogActionType.ModRemovePost -> ModRemovePost
                UniModlogActionType.ModLockPost -> ModLockPost
                UniModlogActionType.ModFeaturePost -> ModFeaturePost
                UniModlogActionType.ModRemoveComment -> ModRemoveComment
                UniModlogActionType.AdminRemoveCommunity -> ModRemoveCommunity
                UniModlogActionType.ModBanFromCommunity -> ModBanFromCommunity
                UniModlogActionType.ModAddToCommunity -> ModAddCommunity
                UniModlogActionType.ModTransferCommunity -> ModTransferCommunity
                UniModlogActionType.AdminAdd -> ModAdd
                UniModlogActionType.AdminBan -> ModBan
                UniModlogActionType.ModChangeCommunityVisibility -> ModHideCommunity
                UniModlogActionType.AdminPurgePerson -> AdminPurgePerson
                UniModlogActionType.AdminPurgeCommunity -> AdminPurgeCommunity
                UniModlogActionType.AdminPurgePost -> AdminPurgePost
                UniModlogActionType.AdminPurgeComment -> AdminPurgeComment
                else -> null
            }

        fun fromUni(uni: UniModlogActionType): ModlogActionType = fromUniNullable(uni) ?: error("No v0 mapping for $uni")
    }
}

internal fun ModlogActionType?.toUni(): UniModlogActionType? = this?.toUni()
