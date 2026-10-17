package it.vercruysse.lemmyapi.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class ResolveCommunityReport(
    val report_id: CommunityReportId,
    val resolved: Boolean,
    /** Added in Lemmy 1.0.0 */
    val conclusion: String? = null,
)
