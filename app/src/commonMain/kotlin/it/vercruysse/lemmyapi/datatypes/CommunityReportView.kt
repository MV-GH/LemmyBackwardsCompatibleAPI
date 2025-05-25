package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class CommunityReportView(
    val community_report: CommunityReport,
    val community: Community,
    val creator: Person,
    val resolver: Person? = null,
): DatatypeRoot
