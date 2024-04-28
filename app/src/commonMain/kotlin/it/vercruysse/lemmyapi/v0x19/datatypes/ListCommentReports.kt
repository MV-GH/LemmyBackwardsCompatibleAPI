package it.vercruysse.lemmyapi.v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class ListCommentReports(
    val comment_id: CommentId? = null, // Added in 0.19.4
    val page: Long? = null,
    val limit: Long? = null,
    val unresolved_only: Boolean? = null,
    val community_id: CommunityId? = null,
)
