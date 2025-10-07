package it.vercruysse.lemmyapi.v1.x0.x0.combinedtypes

import it.vercruysse.lemmyapi.v1.x0.x0.datatypes.AdminAddView
import it.vercruysse.lemmyapi.v1.x0.x0.datatypes.AdminAllowInstanceView
import it.vercruysse.lemmyapi.v1.x0.x0.datatypes.AdminBanView
import it.vercruysse.lemmyapi.v1.x0.x0.datatypes.AdminBlockInstanceView
import it.vercruysse.lemmyapi.v1.x0.x0.datatypes.AdminPurgeCommentView
import it.vercruysse.lemmyapi.v1.x0.x0.datatypes.AdminPurgeCommunityView
import it.vercruysse.lemmyapi.v1.x0.x0.datatypes.AdminPurgePersonView
import it.vercruysse.lemmyapi.v1.x0.x0.datatypes.AdminPurgePostView
import it.vercruysse.lemmyapi.v1.x0.x0.datatypes.AdminRemoveCommunityView
import it.vercruysse.lemmyapi.v1.x0.x0.datatypes.ModAddToCommunityView
import it.vercruysse.lemmyapi.v1.x0.x0.datatypes.ModBanFromCommunityView
import it.vercruysse.lemmyapi.v1.x0.x0.datatypes.ModChangeCommunityVisibilityView
import it.vercruysse.lemmyapi.v1.x0.x0.datatypes.ModFeaturePostView
import it.vercruysse.lemmyapi.v1.x0.x0.datatypes.ModLockCommentView
import it.vercruysse.lemmyapi.v1.x0.x0.datatypes.ModLockPostView
import it.vercruysse.lemmyapi.v1.x0.x0.datatypes.ModRemoveCommentView
import it.vercruysse.lemmyapi.v1.x0.x0.datatypes.ModRemovePostView
import it.vercruysse.lemmyapi.v1.x0.x0.datatypes.ModTransferCommunityView
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonClassDiscriminator

@Serializable
@OptIn(ExperimentalSerializationApi::class)
@JsonClassDiscriminator("type_")
internal sealed class ModlogCombinedView {
    @Serializable
    @SerialName("AdminAllowInstance")
    internal data class AdminAllowInstance(
        val admin_allow_instance: AdminAllowInstanceView,
    ) : ModlogCombinedView()

    @Serializable
    @SerialName("AdminBlockInstance")
    internal data class AdminBlockInstance(
        val admin_block_instance: AdminBlockInstanceView,
    ) : ModlogCombinedView()

    @Serializable
    @SerialName("AdminPurgeComment")
    internal data class AdminPurgeComment(
        val admin_purge_comment: AdminPurgeCommentView,
    ) : ModlogCombinedView()

    @Serializable
    @SerialName("AdminPurgeCommunity")
    internal data class AdminPurgeCommunity(
        val admin_purge_community: AdminPurgeCommunityView,
    ) : ModlogCombinedView()

    @Serializable
    @SerialName("AdminPurgePerson")
    internal data class AdminPurgePerson(
        val admin_purge_person: AdminPurgePersonView,
    ) : ModlogCombinedView()

    @Serializable
    @SerialName("AdminPurgePost")
    internal data class AdminPurgePost(
        val admin_purge_post: AdminPurgePostView,
    ) : ModlogCombinedView()

    @Serializable
    @SerialName("AdminAdd")
    internal data class AdminAdd(
        val admin_add: AdminAddView,
    ) : ModlogCombinedView()

    @Serializable
    @SerialName("ModAddToCommunity")
    internal data class ModAddToCommunity(
        val mod_add_to_community: ModAddToCommunityView,
    ) : ModlogCombinedView()

    @Serializable
    @SerialName("AdminBan")
    internal data class AdminBan(
        val admin_ban: AdminBanView,
    ) : ModlogCombinedView()

    @Serializable
    @SerialName("ModBanFromCommunity")
    internal data class ModBanFromCommunity(
        val mod_ban_from_community: ModBanFromCommunityView,
    ) : ModlogCombinedView()

    @Serializable
    @SerialName("ModFeaturePost")
    internal data class ModFeaturePost(
        val mod_feature_post: ModFeaturePostView,
    ) : ModlogCombinedView()

    @Serializable
    @SerialName("ModChangeCommunityVisibility")
    internal data class ModChangeCommunityVisibility(
        val mod_change_community_visibility: ModChangeCommunityVisibilityView,
    ) : ModlogCombinedView()

    @Serializable
    @SerialName("ModLockPost")
    internal data class ModLockPost(
        val mod_lock_post: ModLockPostView,
    ) : ModlogCombinedView()

    @Serializable
    @SerialName("ModRemoveComment")
    internal data class ModRemoveComment(
        val mod_remove_comment: ModRemoveCommentView,
    ) : ModlogCombinedView()

    @Serializable
    @SerialName("AdminRemoveCommunity")
    internal data class AdminRemoveCommunity(
        val admin_remove_community: AdminRemoveCommunityView,
    ) : ModlogCombinedView()

    @Serializable
    @SerialName("ModRemovePost")
    internal data class ModRemovePost(
        val mod_remove_post: ModRemovePostView,
    ) : ModlogCombinedView()

    @Serializable
    @SerialName("ModTransferCommunity")
    internal data class ModTransferCommunity(
        val mod_transfer_community: ModTransferCommunityView,
    ) : ModlogCombinedView()

    @Serializable
    @SerialName("ModLockComment")
    internal data class ModLockComment(
        val mod_lock_comment: ModLockCommentView,
    ) : ModlogCombinedView()
}
