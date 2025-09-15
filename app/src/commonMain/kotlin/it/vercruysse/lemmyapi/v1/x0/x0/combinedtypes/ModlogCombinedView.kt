package it.vercruysse.lemmyapi.v1.x0.x0.combinedtypes

import it.vercruysse.lemmyapi.v1.x0.x0.datatypes.AdminAllowInstanceView
import it.vercruysse.lemmyapi.v1.x0.x0.datatypes.AdminBlockInstanceView
import it.vercruysse.lemmyapi.v1.x0.x0.datatypes.AdminPurgeCommentView
import it.vercruysse.lemmyapi.v1.x0.x0.datatypes.AdminPurgeCommunityView
import it.vercruysse.lemmyapi.v1.x0.x0.datatypes.AdminPurgePersonView
import it.vercruysse.lemmyapi.v1.x0.x0.datatypes.AdminPurgePostView
import it.vercruysse.lemmyapi.v1.x0.x0.datatypes.ModAddCommunityView
import it.vercruysse.lemmyapi.v1.x0.x0.datatypes.ModAddView
import it.vercruysse.lemmyapi.v1.x0.x0.datatypes.ModBanFromCommunityView
import it.vercruysse.lemmyapi.v1.x0.x0.datatypes.ModBanView
import it.vercruysse.lemmyapi.v1.x0.x0.datatypes.ModChangeCommunityVisibilityView
import it.vercruysse.lemmyapi.v1.x0.x0.datatypes.ModFeaturePostView
import it.vercruysse.lemmyapi.v1.x0.x0.datatypes.ModLockPostView
import it.vercruysse.lemmyapi.v1.x0.x0.datatypes.ModRemoveCommentView
import it.vercruysse.lemmyapi.v1.x0.x0.datatypes.ModRemoveCommunityView
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
    @SerialName("ModAdd")
    internal data class ModAdd(
        val mod_add: ModAddView,
    ) : ModlogCombinedView()

    @Serializable
    @SerialName("ModAddCommunity")
    internal data class ModAddCommunity(
        val mod_add_community: ModAddCommunityView,
    ) : ModlogCombinedView()

    @Serializable
    @SerialName("ModBan")
    internal data class ModBan(
        val mod_ban: ModBanView,
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
    @SerialName("ModRemoveCommunity")
    internal data class ModRemoveCommunity(
        val mod_remove_community: ModRemoveCommunityView,
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
}
