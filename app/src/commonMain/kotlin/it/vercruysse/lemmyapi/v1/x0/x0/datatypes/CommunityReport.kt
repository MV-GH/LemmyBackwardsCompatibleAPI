package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class CommunityReport(
    val id: CommunityReportId,
    val creator_id: PersonId,
    val community_id: CommunityId,
    val original_community_name: String,
    val original_community_title: String,
    val original_community_description: String? = null,
    val original_community_sidebar: String? = null,
    val original_community_icon: String? = null,
    val original_community_banner: String? = null,
    val reason: String,
    val resolved: Boolean,
    val resolver_id: PersonId? = null,
    val published: String,
    val updated: String? = null,
)
