package it.vercruysse.lemmyapi.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class PostReportResponse(
    val post_report_view: PostReportView,
)
