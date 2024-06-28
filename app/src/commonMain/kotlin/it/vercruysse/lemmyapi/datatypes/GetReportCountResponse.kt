package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

@CommonParcelize
@Serializable
data class GetReportCountResponse(
    val community_id: CommunityId? = null,
    val comment_reports: Long,
    val post_reports: Long,
    val private_message_reports: Long? = null,
) : DatatypeRoot
