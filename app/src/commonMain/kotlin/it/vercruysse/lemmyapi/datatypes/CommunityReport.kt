package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.Identity
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class CommunityReport(
    override val id: CommunityReportId,
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
    val published_at: String,
    val updated_at: String? = null,
): DatatypeRoot, Identity
