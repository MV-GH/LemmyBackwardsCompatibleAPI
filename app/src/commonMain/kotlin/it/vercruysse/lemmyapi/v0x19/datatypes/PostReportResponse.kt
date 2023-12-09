package it.vercruysse.lemmyapi.v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class PostReportResponse(
    val post_report_view: PostReportView,
)
