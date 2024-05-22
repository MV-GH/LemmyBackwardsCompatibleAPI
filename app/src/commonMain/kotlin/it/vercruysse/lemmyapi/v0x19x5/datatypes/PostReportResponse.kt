package it.vercruysse.lemmyapi.v0x19x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class PostReportResponse(
    val post_report_view: PostReportView,
)
