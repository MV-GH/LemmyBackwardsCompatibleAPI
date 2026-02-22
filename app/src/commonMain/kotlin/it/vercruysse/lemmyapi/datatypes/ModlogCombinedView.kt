package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.json.JsonClassDiscriminator
import kotlinx.serialization.Serializable


// TODO: most likely wrong

@CommonParcelize
@Serializable
@OptIn(ExperimentalSerializationApi::class)
@JsonClassDiscriminator("type_")
sealed class ModlogCombinedView: DatatypeRoot {
    @CommonParcelize
    @Serializable
    @SerialName("AdminAllowInstance")
    data class AdminAllowInstance(
        val admin_allow_instance: AdminAllowInstanceView
    ) : ModlogCombinedView()

    @CommonParcelize
    @Serializable
    @SerialName("AdminBlockInstance")
    data class AdminBlockInstance(
        val admin_block_instance: AdminBlockInstanceView
    ) : ModlogCombinedView()

    @CommonParcelize
    @Serializable
    @SerialName("AdminPurgeComment")
    data class AdminPurgeComment(
        val admin_purge_comment: AdminPurgeCommentView
    ) : ModlogCombinedView()

    @CommonParcelize
    @Serializable
    @SerialName("AdminPurgeCommunity")
    data class AdminPurgeCommunity(
        val admin_purge_community: AdminPurgeCommunityView
    ) : ModlogCombinedView()

    @CommonParcelize
    @Serializable
    @SerialName("AdminPurgePerson")
    data class AdminPurgePerson(
        val admin_purge_person: AdminPurgePersonView
    ) : ModlogCombinedView()

    @CommonParcelize
    @Serializable
    @SerialName("AdminPurgePost")
    data class AdminPurgePost(
        val admin_purge_post: AdminPurgePostView
    ) : ModlogCombinedView()

    @CommonParcelize
    @Serializable
    @SerialName("AdminAdd")
    internal data class AdminAdd(
        val admin_add: AdminAddView,
    ) : ModlogCombinedView()

    @CommonParcelize
    @Serializable
    @SerialName("ModAddToCommunity")
    internal data class ModAddToCommunity(
        val mod_add_to_community: ModAddToCommunityView,
    ) : ModlogCombinedView()

    @CommonParcelize
    @Serializable
    @SerialName("AdminBan")
    internal data class AdminBan(
        val admin_ban: AdminBanView,
    ) : ModlogCombinedView()

    @CommonParcelize
    @Serializable
    @SerialName("ModBanFromCommunity")
    data class ModBanFromCommunity(
        val mod_ban_from_community: ModBanFromCommunityView
    ) : ModlogCombinedView()

    @CommonParcelize
    @Serializable
    @SerialName("ModFeaturePost")
    data class ModFeaturePost(
        val mod_feature_post: ModFeaturePostView
    ) : ModlogCombinedView()

    @CommonParcelize
    @Serializable
    @SerialName("ModChangeCommunityVisibility")
    data class ModChangeCommunityVisibility(
        val mod_change_community_visibility: ModChangeCommunityVisibilityView
    ) : ModlogCombinedView()

    @CommonParcelize
    @Serializable
    @SerialName("ModLockPost")
    data class ModLockPost(
        val mod_lock_post: ModLockPostView
    ) : ModlogCombinedView()

    @CommonParcelize
    @Serializable
    @SerialName("ModRemoveComment")
    data class ModRemoveComment(
        val mod_remove_comment: ModRemoveCommentView
    ) : ModlogCombinedView()

    @CommonParcelize
    @Serializable
    @SerialName("AdminRemoveCommunity")
    internal data class AdminRemoveCommunity(
        val admin_remove_community: AdminRemoveCommunityView,
    ) : ModlogCombinedView()

    @CommonParcelize
    @Serializable
    @SerialName("ModRemovePost")
    data class ModRemovePost(
        val mod_remove_post: ModRemovePostView
    ) : ModlogCombinedView()

    @CommonParcelize
    @Serializable
    @SerialName("ModTransferCommunity")
    data class ModTransferCommunity(
        val mod_transfer_community: ModTransferCommunityView
    ) : ModlogCombinedView()

    @CommonParcelize
    @Serializable
    @SerialName("ModLockComment")
    internal data class ModLockComment(
        val mod_lock_comment: ModLockCommentView,
    ): ModlogCombinedView()
}
