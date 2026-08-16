package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
@SerialName("community")
data class CommunityReportView(
    val community_report: CommunityReport,
    val community: Community,
    val creator: Person,
    val resolver: Person? = null,
    val creator_is_admin: Boolean,
    val creator_is_moderator: Boolean,
    val creator_banned: Boolean,
    val creator_ban_expires_at: String? = null,
    val creator_banned_from_community: Boolean,
    val creator_community_ban_expires_at: String? = null,
) : DatatypeRoot, ReportCombinedView
