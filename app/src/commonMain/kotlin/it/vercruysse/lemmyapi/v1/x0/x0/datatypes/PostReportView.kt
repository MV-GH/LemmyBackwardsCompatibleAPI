package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class PostReportView(
    val post_report: PostReport,
    val post: Post,
    val community: Community,
    val creator: Person,
    val post_creator: Person,
    val community_actions: CommunityActions? = null,
    val post_actions: PostActions? = null,
    val person_actions: PersonActions? = null,
    val resolver: Person? = null,
    val creator_is_admin: Boolean,
    val creator_is_moderator: Boolean,
    val creator_banned: Boolean,
    val creator_ban_expires_at: String? = null,
    val creator_banned_from_community: Boolean,
    val creator_community_ban_expires_at: String? = null,
)
