package it.vercruysse.lemmyapi.v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class PostReportResponse(
    val post_report_view: PostReportView,
)
