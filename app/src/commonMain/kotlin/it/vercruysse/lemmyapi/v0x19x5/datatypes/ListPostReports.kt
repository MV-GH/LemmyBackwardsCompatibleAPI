package it.vercruysse.lemmyapi.v0x19x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class ListPostReports(
    val page: Long? = null,
    val limit: Long? = null,
    val unresolved_only: Boolean? = null,
    val community_id: CommunityId? = null,
    val post_id: PostId? = null,
)
