package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class CommentReportView(
    val comment_report: CommentReport,
    val comment: Comment,
    val post: Post,
    val community: Community,
    val creator: Person,
    val comment_creator: Person,
    val comment_actions: CommentActions? = null,
    val resolver: Person? = null,
    val creator_community_actions: CommunityActions? = null,
    val person_actions: PersonActions? = null,
    val community_actions: CommunityActions? = null,
    val creator_is_admin: Boolean,
)
