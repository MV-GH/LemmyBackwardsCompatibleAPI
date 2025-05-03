package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class PostReportView(
    val post_report: PostReport,
    val post: Post,
    val community: Community,
    val creator: Person,
    val post_creator: Person,
    val creator_community_actions: CommunityActions? = null,
    val community_actions: CommunityActions? = null,
    val post_actions: PostActions? = null,
    val person_actions: PersonActions? = null,
    val resolver: Person? = null,
    val creator_is_admin: Boolean,
)
