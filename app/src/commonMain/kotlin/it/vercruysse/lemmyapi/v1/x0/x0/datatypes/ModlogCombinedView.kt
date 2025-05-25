package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.json.JsonClassDiscriminator
import kotlinx.serialization.Serializable

@Serializable
@OptIn(ExperimentalSerializationApi::class)
@JsonClassDiscriminator("type_")
internal sealed class ModlogCombinedView {
    @Serializable
    @SerialName("AdminAllowInstance")
    internal data class AdminAllowInstance(
        val admin_allow_instance: AdminAllowInstanceView
    ) : ModlogCombinedView()

    @Serializable
    @SerialName("AdminBlockInstance")
    internal data class AdminBlockInstance(
        val admin_block_instance: AdminBlockInstanceView
    ) : ModlogCombinedView()

    @Serializable
    @SerialName("AdminPurgeComment")
    internal data class AdminPurgeComment(
        val admin_purge_comment: AdminPurgeCommentView
    ) : ModlogCombinedView()

    @Serializable
    @SerialName("AdminPurgeCommunity")
    internal data class AdminPurgeCommunity(
        val admin_purge_community: AdminPurgeCommunityView
    ) : ModlogCombinedView()

    @Serializable
    @SerialName("AdminPurgePerson")
    internal data class AdminPurgePerson(
        val admin_purge_person: AdminPurgePersonView
    ) : ModlogCombinedView()

    @Serializable
    @SerialName("AdminPurgePost")
    internal data class AdminPurgePost(
        val admin_purge_post: AdminPurgePostView
    ) : ModlogCombinedView()

    @Serializable
    @SerialName("ModAdd")
    internal data class ModAdd(
        val mod_add: ModAddView
    ) : ModlogCombinedView()

    @Serializable
    @SerialName("ModAddCommunity")
    internal data class ModAddCommunity(
        val mod_add_community: ModAddCommunityView
    ) : ModlogCombinedView()

    @Serializable
    @SerialName("ModBan")
    internal data class ModBan(
        val mod_ban: ModBanView
    ) : ModlogCombinedView()

    @Serializable
    @SerialName("ModBanFromCommunity")
    internal data class ModBanFromCommunity(
        val mod_ban_from_community: ModBanFromCommunityView
    ) : ModlogCombinedView()

    @Serializable
    @SerialName("ModFeaturePost")
    internal data class ModFeaturePost(
        val mod_feature_post: ModFeaturePostView
    ) : ModlogCombinedView()

    @Serializable
    @SerialName("ModChangeCommunityVisibility")
    internal data class ModChangeCommunityVisibility(
        val mod_change_community_visibility: ModChangeCommunityVisibilityView
    ) : ModlogCombinedView()

    @Serializable
    @SerialName("ModLockPost")
    internal data class ModLockPost(
        val mod_lock_post: ModLockPostView
    ) : ModlogCombinedView()

    @Serializable
    @SerialName("ModRemoveComment")
    internal data class ModRemoveComment(
        val mod_remove_comment: ModRemoveCommentView
    ) : ModlogCombinedView()

    @Serializable
    @SerialName("ModRemoveCommunity")
    internal data class ModRemoveCommunity(
        val mod_remove_community: ModRemoveCommunityView
    ) : ModlogCombinedView()

    @Serializable
    @SerialName("ModRemovePost")
    internal data class ModRemovePost(
        val mod_remove_post: ModRemovePostView
    ) : ModlogCombinedView()

    @Serializable
    @SerialName("ModTransferCommunity")
    internal data class ModTransferCommunity(
        val mod_transfer_community: ModTransferCommunityView
    ) : ModlogCombinedView()
}
