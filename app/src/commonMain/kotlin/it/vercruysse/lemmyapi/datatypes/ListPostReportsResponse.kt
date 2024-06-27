package it.vercruysse.lemmyapi.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class ListPostReportsResponse(
    val post_reports: List<PostReportView>,
)
