package it.vercruysse.lemmyapi.v0.x19.x6.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class PostReportResponse(
    val post_report_view: PostReportView,
)
