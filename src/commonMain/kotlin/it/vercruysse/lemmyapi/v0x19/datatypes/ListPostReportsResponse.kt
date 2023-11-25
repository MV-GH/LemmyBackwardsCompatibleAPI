package it.vercruysse.lemmyapi.v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class ListPostReportsResponse(
    val post_reports: List<PostReportView>,
)
