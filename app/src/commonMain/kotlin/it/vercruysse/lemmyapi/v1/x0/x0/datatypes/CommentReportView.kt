package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("comment")
internal data class CommentReportView(
    val comment_report: CommentReport,
    val comment: Comment,
    val post: Post,
    val community: Community,
    val creator: Person,
    val comment_creator: Person,
    val comment_actions: CommentActions? = null,
    val resolver: Person? = null,
    val person_actions: PersonActions? = null,
    val community_actions: CommunityActions? = null,
    val creator_is_admin: Boolean,
    val creator_is_moderator: Boolean,
    val creator_banned: Boolean,
    val creator_ban_expires_at: String? = null,
    val creator_banned_from_community: Boolean,
    val creator_community_ban_expires_at: String? = null,
) : ReportCombinedView
