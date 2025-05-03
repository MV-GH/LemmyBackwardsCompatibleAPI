package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class GetModlogResponse(
    val modlog: List<dynamic /* `T$3` & AdminAllowInstanceView | `T$4` & AdminBlockInstanceView | `T$5` & AdminPurgeCommentView | `T$6` & AdminPurgeCommunityView | `T$7` & AdminPurgePersonView | `T$8` & AdminPurgePostView | `T$9` & ModAddView | `T$10` & ModAddCommunityView | `T$11` & ModBanView | `T$12` & ModBanFromCommunityView | `T$13` & ModFeaturePostView | `T$14` & ModChangeCommunityVisibilityView | `T$15` & ModLockPostView | `T$16` & ModRemoveCommentView | `T$17` & ModRemoveCommunityView | `T$18` & ModRemovePostView | `T$19` & ModTransferCommunityView */>,
    val next_page: PaginationCursor? = null,
    val prev_page: PaginationCursor? = null,
)
