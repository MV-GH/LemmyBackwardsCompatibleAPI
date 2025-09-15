package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize


@CommonParcelize
@Serializable
data class PostReportView(
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
    val creator_banned_from_community: Boolean,
) : DatatypeRoot
